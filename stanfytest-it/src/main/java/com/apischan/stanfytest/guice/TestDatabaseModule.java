package com.apischan.stanfytest.guice;

import com.apischan.stanfytest.repository.CandidateRepository;
import com.apischan.stanfytest.repository.SkillRepository;
import com.apischan.stanfytest.repository.impl.CandidateRepositoryImpl;
import com.apischan.stanfytest.repository.impl.SkillRepositoryImpl;
import com.apischan.stanfytest.repository.util.H2ConnectionProvider;
import com.apischan.stanfytest.repository.util.JooqConnectionProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class TestDatabaseModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(JooqConnectionProvider.class).to(H2ConnectionProvider.class).in(Scopes.SINGLETON);
        bind(CandidateRepository.class).to(CandidateRepositoryImpl.class);
        bind(SkillRepository.class).to(SkillRepositoryImpl.class);
    }
}
