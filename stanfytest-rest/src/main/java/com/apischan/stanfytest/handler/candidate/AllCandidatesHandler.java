package com.apischan.stanfytest.handler.candidate;

import com.apischan.stanfytest.service.CandidateService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import ratpack.handling.Context;

import static ratpack.jackson.Jackson.json;

@Singleton
@Slf4j
public class AllCandidatesHandler extends AbstractCandidateHandler {

    @Inject
    public AllCandidatesHandler(CandidateService candidateService) {
        super(candidateService);
    }

    @Override
    public void handle(Context ctx) throws Exception {
        log.info("Request of {}", getClass());
        ctx.render(json(candidateService.getAllCandidates()));
    }
}
