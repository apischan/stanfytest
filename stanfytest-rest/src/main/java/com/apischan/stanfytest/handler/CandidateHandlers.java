package com.apischan.stanfytest.handler;

import com.apischan.stanfytest.dto.CandidateDto;
import com.apischan.stanfytest.dto.SkillDto;
import com.apischan.stanfytest.service.CandidateService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import ratpack.exec.Promise;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;

import static ratpack.jackson.Jackson.*;

public final class CandidateHandlers {

    private CandidateHandlers() {}

    @Singleton
    @Slf4j
    public static class AllCandidatesHandler implements Handler {

        private final CandidateService candidateService;

        @Inject
        public AllCandidatesHandler(CandidateService candidateService) {
            this.candidateService = candidateService;
        }

        @Override
        public void handle(Context ctx) throws Exception {
            log.info("Request of {}", getClass());
            ctx.render(json(candidateService.getAllCandidates()));
        }
    }

    @Singleton
    @Slf4j
    public static class CandidateByIdHandler implements Handler {

        private final CandidateService candidateService;

        @Inject
        public CandidateByIdHandler(CandidateService candidateService) {
            this.candidateService = candidateService;
        }
        @Override
        public void handle(Context ctx) throws Exception {
            log.info("Request of {}", getClass());
            Integer id = Integer.valueOf(ctx.getPathTokens().get("id"));
            ctx.render(json(candidateService.getCandidateById(id)));
        }
    }

    @Singleton
    @Slf4j
    public static class StoreCandidateHandler implements Handler {

        private final CandidateService candidateService;

        @Inject
        public StoreCandidateHandler(CandidateService candidateService) {
            this.candidateService = candidateService;
        }
        @Override
        public void handle(Context ctx) throws Exception {
            log.info("Request of {}", getClass());
            Promise<CandidateDto> candidatePromise = ctx.parse(fromJson(CandidateDto.class));
            candidatePromise.then(candidate -> {
                candidateService.saveCandidate(candidate);
                ctx.getResponse().status(Status.OK).send();
            });
        }
    }
}
