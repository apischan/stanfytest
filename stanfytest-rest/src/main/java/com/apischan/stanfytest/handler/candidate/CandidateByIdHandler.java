package com.apischan.stanfytest.handler.candidate;

import com.apischan.stanfytest.service.CandidateService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import ratpack.handling.Context;

import static ratpack.jackson.Jackson.json;

@Singleton
@Slf4j
public class CandidateByIdHandler extends AbstractCandidateHandler {

    @Inject
    public CandidateByIdHandler(CandidateService candidateService) {
        super(candidateService);
    }
    @Override
    public void handle(Context ctx) throws Exception {
        log.info("Request of {}", getClass());
        Integer id = Integer.valueOf(ctx.getPathTokens().get("id"));
        ctx.render(json(candidateService.getCandidateById(id)));
    }
}
