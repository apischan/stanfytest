package com.apischan.stanfytest.repository;
import com.apischan.stanfytest.dto.SkillDto;
import com.apischan.stanfytest.exceptions.EntryNotFoundException;
import com.apischan.stanfytest.exceptions.JobsException;
import com.apischan.stanfytest.dto.CandidateDto;
import com.apischan.stanfytest.repository.util.ConnectionProvider;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.SelectOnConditionStep;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Stream;

import static com.apischan.stanfytest.jooq.Tables.*;
import static java.util.stream.Collectors.*;
import static org.jooq.impl.DSL.*;

public class CandidateRepositoryImpl implements CandidateRepository {

    private ConnectionProvider connectionProvider;

    @Inject
    private CandidateRepositoryImpl(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    /**
     * Get candidate by id
     *
     * @param id identifier of candidate
     * @return candidate dto
     */
    @Transactional
    public CandidateDto getCandidateById(int id) {
        try (Connection connection = connectionProvider.getConnection()) {
            DSLContext create = using(connection);
            SelectOnConditionStep<Record3<String, String, String>> query = create
                    .select(
                            CANDIDATE.FIRSTNAME,
                            CANDIDATE.LASTNAME,
                            SKILL.NAME)
                    .from(CANDIDATE)
                    .innerJoin(CANDIDATE_SKILL)
                    .on(CANDIDATE.ID.eq(CANDIDATE_SKILL.CANDIDATE_ID)).and(CANDIDATE.ID.eq(id))
                    .innerJoin(SKILL)
                    .on(SKILL.ID.eq(CANDIDATE_SKILL.SKILL_ID));

            Map<CandidateDto, List<SkillDto>> result = query
                    .fetch()
                    .stream()
                    .collect(groupingBy(
                            r -> {
                                String firstname = r.getValue(CANDIDATE.FIRSTNAME, String.class);
                                String lastname = r.getValue(CANDIDATE.LASTNAME, String.class);
                                return new CandidateDto(firstname, lastname);
                            },
                            mapping(r -> new SkillDto(r.getValue(SKILL.NAME, String.class)), toList())
                    ));

            connection.close();

            return convertToCandidateDto(result)
                    .findFirst()
                    .orElseThrow(() -> new EntryNotFoundException("Candidate with such id not found."));
        } catch (SQLException e) {
            throw new JobsException(e);
        }
    }

    private Stream<CandidateDto> convertToCandidateDto(Map<CandidateDto, List<SkillDto>> result) {
        Set<Map.Entry<CandidateDto, List<SkillDto>>> entries = result.entrySet();
        return entries.stream()
                .map(e -> {
                    CandidateDto candidate = e.getKey();
                    List<SkillDto> skills = e.getValue();
                    candidate.setSkills(skills);
                    return candidate;
                });
    }

}
