package com.apischan.stanfytest.repository.impl;

import com.apischan.stanfytest.dto.SkillDto;
import com.apischan.stanfytest.repository.SkillRepository;
import com.apischan.stanfytest.repository.util.JooqConnectionProvider;
import com.google.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;

import java.util.Optional;

import static com.apischan.stanfytest.jooq.Tables.SKILL;
import static org.jooq.impl.DSL.using;

public class SkillRepositoryImpl implements SkillRepository {

    private JooqConnectionProvider connectionProvider;

    @Inject
    public SkillRepositoryImpl(JooqConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public Optional<Integer> getSkillIdByName(String name, DSLContext context) {
        return context
                .select(SKILL.ID)
                .from(SKILL)
                .where(SKILL.NAME.equalIgnoreCase(name))
                .fetchOptional(SKILL.ID);
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
}
