package com.apischan.stanfytest.repository.impl;

import com.apischan.stanfytest.dto.SkillDto;
import com.apischan.stanfytest.exceptions.EntryNotFoundException;
import com.apischan.stanfytest.repository.SkillRepository;
import com.apischan.stanfytest.repository.util.JooqConnectionProvider;
import com.google.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.SQLDialect;

import java.util.List;
import java.util.Optional;

import static com.apischan.stanfytest.jooq.Tables.SKILL;
import static java.util.stream.Collectors.*;
import static org.jooq.impl.DSL.using;

public class SkillRepositoryImpl implements SkillRepository {

    private JooqConnectionProvider connectionProvider;

    @Inject
    public SkillRepositoryImpl(JooqConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public SkillDto getSkillByName(String name) {
        try (DSLContext create = using(connectionProvider, connectionProvider.getSqlDialect(), connectionProvider.getSettings())) {
            Optional<Record2<Integer, String>> optResult = create.transactionResult(configuration -> using(configuration)
                    .select(SKILL.ID, SKILL.NAME)
                    .from(SKILL)
                    .where(SKILL.NAME.equalIgnoreCase(name))
                    .fetchOptional());
            Record2<Integer, String> result = optResult.orElseThrow(() ->
                    new EntryNotFoundException("Entry with such name not found.")
            );
            return SkillDto.of(result.getValue(SKILL.ID), result.getValue(SKILL.NAME));
        }
    }

    @Override
    public SkillDto getSkillById(Integer id) {
        try (DSLContext create = using(connectionProvider, connectionProvider.getSqlDialect(), connectionProvider.getSettings())) {
            Optional<Record2<Integer, String>> optResult = create.transactionResult(configuration -> using(configuration)
                    .select(SKILL.ID, SKILL.NAME)
                    .from(SKILL)
                    .where(SKILL.ID.eq(id))
                    .fetchOptional());
            Record2<Integer, String> result = optResult.orElseThrow(() ->
                    new EntryNotFoundException("Entry with such id not found.")
            );
            return SkillDto.of(result.getValue(SKILL.ID), result.getValue(SKILL.NAME));
        }
    }

    @Override
    public Integer saveSkill(SkillDto skill, DSLContext context) {
        return context
                .insertInto(SKILL)
                .set(SKILL.NAME, skill.getSkillName())
                .returning(SKILL.ID)
                .fetchOne()
                .getId();
    }

    @Override
    public List<SkillDto> getAllSkills() {
        try (DSLContext create = using(connectionProvider, SQLDialect.POSTGRES_9_3)) {
            return create.transactionResult(configuration ->
                    using(configuration)
                    .select(SKILL.ID, SKILL.NAME)
                    .from(SKILL)
                    .fetch().stream()
                    .map(record -> SkillDto.of(record.getValue(SKILL.ID), record.getValue(SKILL.NAME)))
                    .collect(toList())
            );
        }
    }
}
