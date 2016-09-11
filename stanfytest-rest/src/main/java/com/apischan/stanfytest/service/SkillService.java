package com.apischan.stanfytest.service;

import com.apischan.stanfytest.dto.SkillDto;

import java.util.List;

public interface SkillService {

    /**
     * Retrieve skill by it's instance id
     *
     * @param skillId instance id of skill
     * @return skill dto
     */
    SkillDto getSkillById(Integer skillId);

    /**
     * Retrieve skill by it's instance name
     *
     * @param skillName name of skill
     * @return skill dto
     */
    SkillDto getSkillByName(String skillName);

    /**
     * Retrieve all skill instances from database
     *
     * @return all skill dtos from database
     */
    List<SkillDto> getAllSkills();
}
