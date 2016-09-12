package com.apischan.stanfytest.repository;

import com.apischan.stanfytest.dto.SkillDto;
import org.jooq.DSLContext;

import java.util.List;

public interface SkillRepository {

    /**
     * Get skill dto by skill name
     *
     * @param name skill name
     * @return skill dto
     */
    SkillDto getSkillByName(String name);

    /**
     * Get skill dto by skill name
     *
     * @param id skill id
     * @return skill dto
     */
    SkillDto getSkillById(Integer id);

    /**
     * Save skill record into database
     *
     * @param skill skill dto
     * @param context query context with transaction
     * @return instance id of inserted skill
     */
    Integer saveSkill(SkillDto skill, DSLContext context);

    /**
     * Retrieve all skill dtos from database
     *
     * @return all skill dtos from database
     */
    List<SkillDto> getAllSkills();
}
