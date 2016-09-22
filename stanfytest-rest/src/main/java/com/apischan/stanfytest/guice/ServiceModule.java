package com.apischan.stanfytest.guice;

import com.apischan.stanfytest.handler.candidate.AllCandidatesHandler;
import com.apischan.stanfytest.handler.candidate.CandidateByIdHandler;
import com.apischan.stanfytest.handler.candidate.StoreCandidateHandler;
import com.apischan.stanfytest.handler.skill.SkillByIdHandler;
import com.apischan.stanfytest.handler.skill.SkillByQueryHandler;
import com.apischan.stanfytest.service.CandidateService;
import com.apischan.stanfytest.service.SkillService;
import com.apischan.stanfytest.service.impl.CandidateServiceImpl;
import com.apischan.stanfytest.service.impl.SkillServiceImpl;
import com.google.inject.AbstractModule;

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
