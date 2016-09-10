package com.apischan.stanfytest.repository.impl;
import com.apischan.stanfytest.dto.SkillDto;
import com.apischan.stanfytest.exceptions.EntryNotFoundException;
import com.apischan.stanfytest.exceptions.JobsException;
import com.apischan.stanfytest.dto.CandidateDto;
import com.apischan.stanfytest.repository.CandidateRepository;
import com.apischan.stanfytest.repository.SkillRepository;
import com.apischan.stanfytest.repository.util.JooqConnectionProvider;
import com.google.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.SQLDialect;
import org.jooq.SelectOnConditionStep;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Stream;

import static com.apischan.stanfytest.jooq.Tables.*;
import static java.util.stream.Collectors.*;
import static org.jooq.impl.DSL.*;

public class CandidateRepositoryImpl implements CandidateRepository {

    private JooqConnectionProvider connectionProvider;
    private SkillRepository skillRepository;

    @Inject
    private CandidateRepositoryImpl(JooqConnectionProvider connectionProvider,
                                    SkillRepository skillRepository) {
        this.connectionProvider = connectionProvider;
        this.skillRepository = skillRepository;
    }

    @Override
    public CandidateDto getCandidateById(int id) {
        try (DSLContext create = using(connectionProvider, SQLDialect.POSTGRES_9_3)) {
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
                            r -> new CandidateDto(r.getValue(CANDIDATE.FIRSTNAME), r.getValue(CANDIDATE.LASTNAME)),
                            mapping(r -> new SkillDto(r.getValue(SKILL.NAME, String.class)), toList())
                    ));

            return convertToCandidateDto(result)
                    .findFirst()
                    .orElseThrow(() -> new EntryNotFoundException("Candidate with such id not found."));
        }

    }

    @Override
    public void saveCandidate(CandidateDto candidate) {

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
