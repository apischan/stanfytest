package com.apischan.stanfytest.handler.skill;

import com.apischan.stanfytest.service.SkillService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

@Singleton
public class SkillByIdHandler extends AbstractSkillHandler {

    @Inject
    public SkillByIdHandler(SkillService skillService) {
        super(skillService);
    }

    @Override
    public void handle(Context ctx) throws Exception {
        Integer id = Integer.valueOf(ctx.getPathTokens().get("id"));
        ctx.render(json(skillService.getSkillById(id)));
    }
}
