package com.apischan.stanfytest

import com.apischan.stanfytest.dto.CandidateDto
import com.apischan.stanfytest.dto.SkillDto
import com.apischan.stanfytest.guice.ServiceModule
import com.apischan.stanfytest.guice.TestDatabaseModule
import com.apischan.stanfytest.route.RouterChain
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import ratpack.groovy.test.embed.GroovyEmbeddedApp
import ratpack.guice.Guice
import ratpack.test.embed.EmbeddedApp
import ratpack.test.http.TestHttpClient
import spock.lang.Shared
import spock.lang.Specification

import java.sql.Connection
import java.sql.DriverManager

class CandidateIntegrationTest extends Specification {

    @Shared Connection db;
    @Shared EmbeddedApp server;
    @Shared ObjectMapper objectMapper = new ObjectMapper()
    @Delegate TestHttpClient client = testHttpClient(server)

    def setupSpec() {
        db = DriverManager.getConnection("jdbc:h2:mem:jobsdb;" +
                "DB_CLOSE_DELAY=-1;" +
                "INIT=" +
                "runscript from 'scripts/schema.sql'\\;" +
                "runscript from 'scripts/data.sql'",
                "SA", "")
        server = GroovyEmbeddedApp.of {
            registry Guice.registry {
                    it.module(ServiceModule)
                    it.module(TestDatabaseModule)
                } handlers(new RouterChain())
        }
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        DatabaseManagerSwing.main(['--url', 'jdbc:h2:mem:jobsdb', '--user', 'sa', '--password', '' ] as String[]);
    }

    def cleanupSpec() {
        db.close()
    }

    def "get one candidates"() {
        given:
        def candidateDto = CandidateDto.of(1, 'John', 'Travolta')
        candidateDto.setSkills([
                SkillDto.of(1, 'html'),
                SkillDto.of(2, 'css'),
                SkillDto.of(3, 'javascript')
        ])
        def jsonCandidate = objectMapper.writeValueAsString(candidateDto)

        when:
        get('candidates/1')

        then:
        response.statusCode == 200
        response.body.text == jsonCandidate
    }

    def "get all candidates"() {
        given:
        def candidateDto = CandidateDto.of(3, 'Leonardo', 'DiCaprio')
        candidateDto.setSkills([
                SkillDto.of(5, 'android'),
                SkillDto.of(6, 'spring')
        ])
        def jsonCandidate = objectMapper.writeValueAsString(candidateDto)

        when:
        get('candidates')

        then:
        response.statusCode == 200
        response.body.text.contains(jsonCandidate)
    }

    def "save candidate"() {
        given:
        def candidateDto = new CandidateDto(firstname: 'Nucolas', lastname: 'Cage')
        candidateDto.setSkills([
                new SkillDto(skillName: 'linux'),
                SkillDto.of(6, 'spring')
        ])
        def jsonCandidate = objectMapper.writeValueAsString(candidateDto)

        when:
        def postResponse = requestSpec { spec ->
            spec.headers.add('Content-Type', 'application/json')
            spec.body.text(jsonCandidate)
        }.post('candidate')
        def getResponse = get('candidates')


        then:
        postResponse.statusCode == 200
        getResponse.body.text.contains('"firstname":"Nucolas","lastname":"Cage"')
        getResponse.body.text.contains('"skillName":"linux"')
    }

}
