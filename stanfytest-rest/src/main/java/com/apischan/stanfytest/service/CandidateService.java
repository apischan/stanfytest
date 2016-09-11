package com.apischan.stanfytest.service;

import com.apischan.stanfytest.dto.CandidateDto;

import java.util.List;

public interface CandidateService {
    /**
     * Retrieve all candidates
     *
     * @return all candidates from database with their skills
     */
    List<CandidateDto> getAllCandidates();

    /**
     * Retrieve candidate by id
     *
     * @param id instance id of candidate
     * @return candidate dto
     */
    CandidateDto getCandidateById(Integer id);
}
