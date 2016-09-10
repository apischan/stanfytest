package com.apischan.stanfytest.guice;

import com.apischan.stanfytest.repository.CandidateRepository;
import com.apischan.stanfytest.repository.CandidateRepositoryImpl;
import com.apischan.stanfytest.repository.util.ConnectionProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class DatabaseModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ConnectionProvider.class).in(Scopes.SINGLETON);
        bind(CandidateRepository.class).to(CandidateRepositoryImpl.class);
    }
}
