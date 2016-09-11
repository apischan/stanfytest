package com.apischan.stanfytest.guice;

import com.apischan.stanfytest.service.CandidateService;
import com.apischan.stanfytest.service.impl.CandidateServiceImpl;
import com.google.inject.AbstractModule;

import static com.apischan.stanfytest.handler.CandidateHandlers.*;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CandidateService.class).to(CandidateServiceImpl.class);
        bind(AllCandidatesHandler.class);
        bind(CandidateByIdHandler.class);
    }
}
