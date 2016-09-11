package com.apischan.stanfytest.service.impl;

import com.apischan.stanfytest.dto.SkillDto;
import com.apischan.stanfytest.repository.SkillRepository;
import com.apischan.stanfytest.service.SkillService;
import com.google.inject.Inject;

import java.util.List;

public class SkillServiceImpl implements SkillService {

    private SkillRepository skillRepository;

    @Inject
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillDto getSkillById(Integer skillId) {
        return skillRepository.getSkillById(skillId);
    }

    @Override
    public SkillDto getSkillByName(String skillName) {
        return skillRepository.getSkillByName(skillName);
    }

    @Override
    public List<SkillDto> getAllSkills() {
        return skillRepository.getAllSkills();
    }
}
