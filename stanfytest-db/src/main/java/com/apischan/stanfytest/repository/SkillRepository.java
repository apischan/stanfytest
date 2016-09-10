package com.apischan.stanfytest.repository;

import com.apischan.stanfytest.dto.SkillDto;

import java.util.Optional;

public interface SkillRepository {

    /**
     * Get skill instance id by it's name
     *
     * @param name skill name
     * @return optional of skill instance id
     */
    Optional<Integer> getSkillIdByName(String name);

    /**
     * Insert new skill into database
     *
     * @param skill skill dto
     */
    void saveSkill(SkillDto skill);

}
