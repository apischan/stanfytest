package com.apischan.stanfytest.repository;

import com.apischan.stanfytest.dto.CandidateDto;

public interface CandidateRepository {

    /**
     * Get candidate by id
     *
     * @param id identifier of candidate
     * @return candidate dto
     */
    CandidateDto getCandidateById(int id);
}
