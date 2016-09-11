package com.apischan.stanfytest.repository;

import com.apischan.stanfytest.dto.SkillDto;
import org.jooq.DSLContext;

public interface SkillRepository {

    /**
     * Save skill record into database
     *
     * @param skill skill dto
     * @param context query context with transaction
     * @return instance id of inserted skill
     */
    Integer saveSkill(SkillDto skill, DSLContext context);
}
