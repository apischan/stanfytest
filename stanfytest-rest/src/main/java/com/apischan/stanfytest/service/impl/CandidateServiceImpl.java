package com.apischan.stanfytest.service.impl;

import com.apischan.stanfytest.dto.CandidateDto;
import com.apischan.stanfytest.repository.CandidateRepository;
import com.apischan.stanfytest.service.CandidateService;
import com.google.inject.Inject;

import java.util.List;

public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    @Inject
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<CandidateDto> getAllCandidates() {
        return candidateRepository.getAllCandidates();
    }

    @Override
    public CandidateDto getCandidateById(Integer id) {
        return candidateRepository.getCandidateById(id);
    }
}
