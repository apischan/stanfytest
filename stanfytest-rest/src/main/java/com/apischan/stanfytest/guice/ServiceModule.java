package com.apischan.stanfytest.guice;

import com.apischan.stanfytest.handler.CandidateHandlers;
import com.apischan.stanfytest.service.CandidateService;
import com.apischan.stanfytest.service.impl.CandidateServiceImpl;
import com.google.inject.AbstractModule;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CandidateService.class).to(CandidateServiceImpl.class);
        bind(CandidateHandlers.AllCandidatesHandler.class);
    }
}
