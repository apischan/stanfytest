package com.apischan.stanfytest.handler.candidate;

import com.apischan.stanfytest.service.CandidateService;
import ratpack.handling.Handler;

abstract class AbstractCandidateHandler implements Handler {

    final CandidateService candidateService;

    AbstractCandidateHandler(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

}
