package com.apischan.stanfytest.guice;

import com.apischan.stanfytest.service.CandidateService;
import com.apischan.stanfytest.service.SkillService;
import com.apischan.stanfytest.service.impl.CandidateServiceImpl;
import com.apischan.stanfytest.service.impl.SkillServiceImpl;
import com.google.inject.AbstractModule;

import static com.apischan.stanfytest.handler.CandidateHandlers.*;
import static com.apischan.stanfytest.handler.SkillHandlers.*;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CandidateService.class).to(CandidateServiceImpl.class);
        bind(AllCandidatesHandler.class);
        bind(CandidateByIdHandler.class);
        bind(StoreCandidateHandler.class);

        bind(SkillService.class).to(SkillServiceImpl.class);
        bind(SkillByIdHandler.class);
        bind(SkillByQueryHandler.class);
    }
}
