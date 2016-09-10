package com.apischan.stanfytest.repository.impl;

import com.apischan.stanfytest.exceptions.JobsException;
import com.apischan.stanfytest.repository.SkillRepository;
import com.apischan.stanfytest.repository.util.ConnectionProvider;
import com.google.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SelectConditionStep;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import static com.apischan.stanfytest.jooq.Tables.*;
import static org.jooq.impl.DSL.*;

public class SkillRepositoryImpl implements SkillRepository {

    private ConnectionProvider connectionProvider;

    @Inject
    public SkillRepositoryImpl(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public Optional<Integer> getSkillIdByName(String name) {
        try (Connection connection = connectionProvider.getConnection()) {
            DSLContext create = using(connection);
            SelectConditionStep<Record1<Integer>> query = create
                    .select(SKILL.ID)
                    .from(SKILL)
                    .where(SKILL.NAME.eq(name));
            System.out.println(query.fetchOne());
            return query.fetchOptional(SKILL.ID);
        } catch (SQLException e) {
            throw new JobsException(e);
        }
    }
}
