package com.apischan.stanfytest.handler.skill;

import com.apischan.stanfytest.service.SkillService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.handling.Context;
import ratpack.util.MultiValueMap;

import static ratpack.jackson.Jackson.json;

@Singleton
public class SkillByQueryHandler extends AbstractSkillHandler {

    @Inject
    public SkillByQueryHandler(SkillService skillService) {
        super(skillService);
    }

    @Override
    public void handle(Context ctx) throws Exception {
        MultiValueMap<String, String> queryParams = ctx.getRequest().getQueryParams();
        if (queryParams.containsKey(QueryParamTokens.NAME.token)) {
            String name = queryParams.get(QueryParamTokens.NAME.token);
            ctx.render(json(skillService.getSkillByName(name)));
        } else {
            ctx.render(json(skillService.getAllSkills()));
        }
    }

    private enum QueryParamTokens {
        NAME("name");

        private String token;

        QueryParamTokens(String token) {
            this.token = token;
        }
    }
}
