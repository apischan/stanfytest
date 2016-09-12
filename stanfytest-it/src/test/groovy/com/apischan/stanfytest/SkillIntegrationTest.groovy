package com.apischan.stanfytest

import com.apischan.stanfytest.dto.SkillDto
import com.apischan.stanfytest.guice.ServiceModule
import com.apischan.stanfytest.guice.TestDatabaseModule
import com.apischan.stanfytest.route.RouterChain
import com.fasterxml.jackson.databind.ObjectMapper
import ratpack.groovy.test.embed.GroovyEmbeddedApp
import ratpack.guice.Guice
import ratpack.test.embed.EmbeddedApp
import ratpack.test.http.TestHttpClient
import spock.lang.Shared
import spock.lang.Specification

import java.sql.Connection
import java.sql.DriverManager

class SkillIntegrationTest extends Specification {

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
    }

    def cleanupSpec() {
        db.close()
    }

    def "get skill by id"() {
        given:
        def skillDto = SkillDto.of(1, 'html')
        def jsonSkill = objectMapper.writeValueAsString(skillDto)

        when:
        get('skills/1')

        then:
        response.statusCode == 200
        response.body.text == jsonSkill
    }

    def "get skill by name"() {
        given:
        def skillDto = SkillDto.of(1, 'html')
        def jsonSkill = objectMapper.writeValueAsString(skillDto)

        when:
        params { spec ->
            spec.put('name', 'html')
        }.get('skills')

        then:
        response.statusCode == 200
        response.body.text == jsonSkill
    }

    def "get all skill"() {
        given:
        def skillDto = SkillDto.of(2, 'css')
        def jsonSkill = objectMapper.writeValueAsString(skillDto)

        when:
        get('skills')

        then:
        response.statusCode == 200
        response.body.text.contains(jsonSkill)
    }
}
