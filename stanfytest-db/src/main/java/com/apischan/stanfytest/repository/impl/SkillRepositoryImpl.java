package com.apischan.stanfytest.repository.impl;

import com.apischan.stanfytest.dto.SkillDto;
import com.apischan.stanfytest.repository.SkillRepository;
import org.jooq.DSLContext;

import static com.apischan.stanfytest.jooq.Tables.SKILL;

public class SkillRepositoryImpl implements SkillRepository {

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
