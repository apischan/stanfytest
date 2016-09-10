package com.apischan.stanfytest.repository;

import com.apischan.stanfytest.dto.CandidateDto;

public interface CandidateRepository {

    CandidateDto getCandidateById(int id);
}
