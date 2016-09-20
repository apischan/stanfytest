package com.apischan.stanfytest.handler.skill;

import com.apischan.stanfytest.service.SkillService;
import ratpack.handling.Handler;

abstract class AbstractSkillHandler implements Handler {

    final SkillService skillService;

    AbstractSkillHandler(SkillService skillService) {
        this.skillService = skillService;
    }
}
