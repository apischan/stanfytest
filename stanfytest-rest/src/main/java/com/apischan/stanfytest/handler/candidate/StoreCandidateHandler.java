package com.apischan.stanfytest.handler.candidate;

import com.apischan.stanfytest.dto.CandidateDto;
import com.apischan.stanfytest.service.CandidateService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import ratpack.exec.Promise;
import ratpack.handling.Context;
import ratpack.http.Status;

import static ratpack.jackson.Jackson.fromJson;

@Singleton
@Slf4j
public class StoreCandidateHandler extends AbstractCandidateHandler {

    @Inject
    public StoreCandidateHandler(CandidateService candidateService) {
        super(candidateService);
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
