package com.apischan.stanfytest.repository;

import com.apischan.stanfytest.dto.SkillDto;
import org.jooq.DSLContext;

import java.util.Optional;

import static com.apischan.stanfytest.jooq.Tables.SKILL;

public interface SkillRepository {

    /**
     * Get skill instance id by it's name
     *
     * @param name skill name
     * @return optional of skill instance id
     */
    Optional<Integer> getSkillIdByName(String name, DSLContext context);

    /**
     * Save skill record into database
     *
     * @param skill skill dto
     * @param context query context with transaction
     * @return instance id of inserted skill
     */
    Integer saveSkill(SkillDto skill, DSLContext context);
}
