package com.apischan.stanfytest.handler;

import com.apischan.stanfytest.service.SkillService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.util.MultiValueMap;

import static ratpack.jackson.Jackson.*;

public final class SkillHandlers {

    private SkillHandlers() {}

    @Singleton
    public static class SkillByIdHandler implements Handler {

        private final SkillService skillService;

        @Inject
        public SkillByIdHandler(SkillService skillService) {
            this.skillService = skillService;
        }

        @Override
        public void handle(Context ctx) throws Exception {
            Integer id = Integer.valueOf(ctx.getPathTokens().get("id"));
            ctx.render(json(skillService.getSkillById(id)));
        }
    }

    @Singleton
    public static class SkillByQueryHandler implements Handler {

        private final SkillService skillService;

        @Inject
        public SkillByQueryHandler(SkillService skillService) {
            this.skillService = skillService;
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
}
