package com.apischan.stanfytest.handler;

import com.apischan.stanfytest.service.CandidateService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.*;

public final class CandidateHandlers {

    private CandidateHandlers() {}

    @Singleton
    public static class AllCandidatesHandler implements Handler {

        private final CandidateService candidateService;

        @Inject
        public AllCandidatesHandler(CandidateService candidateService) {
            this.candidateService = candidateService;
        }

        @Override
        public void handle(Context ctx) throws Exception {
            ctx.render(json(candidateService.getAllCandidates()));
        }
    }

    @Singleton
    public static class CandidateByIdHandler implements Handler {

        private final CandidateService candidateService;

        @Inject
        public CandidateByIdHandler(CandidateService candidateService) {
            this.candidateService = candidateService;
        }
        @Override
        public void handle(Context ctx) throws Exception {
            Integer id = Integer.valueOf(ctx.getPathTokens().get("id"));
            ctx.render(json(candidateService.getCandidateById(id)));
        }
    }
}
