package com.apischan.stanfytest.repository.impl;

import com.apischan.stanfytest.dto.SkillDto;
import com.apischan.stanfytest.exceptions.JobsException;
import com.apischan.stanfytest.repository.SkillRepository;
import com.apischan.stanfytest.repository.util.JooqConnectionProvider;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import static com.apischan.stanfytest.jooq.Tables.*;
import static org.jooq.impl.DSL.*;

@Transactional
public class SkillRepositoryImpl implements SkillRepository {

    private JooqConnectionProvider connectionProvider;

    @Inject
    public SkillRepositoryImpl(JooqConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public Optional<Integer> getSkillIdByName(String name) {
        try (DSLContext create = using(connectionProvider, SQLDialect.POSTGRES_9_3)) {
            SelectConditionStep<Record1<Integer>> query = create
                    .select(SKILL.ID)
                    .from(SKILL)
                    .where(SKILL.NAME.eq(name));
            return query.fetchOptional(SKILL.ID);
        }
    }

    @Override
    public void saveSkill(SkillDto skill) {

    }
}
