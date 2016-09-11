package com.apischan.stanfytest.repository;

import com.apischan.stanfytest.dto.CandidateDto;

import java.util.List;

public interface CandidateRepository {

    /**
     * Get candidate by id
     *
     * @param id identifier of candidate
     * @return candidate dto
     */
    CandidateDto getCandidateById(int id);

    /**
     * Fetch all candidates with their skills from database
     *
     * @return all candidates with their skills from database
     */
    List<CandidateDto> getAllCandidates();

    /**
     * Inserts candidate and it's skills into database
     *
     * @param candidate candidate dto
     */
    void saveCandidate(CandidateDto candidate);
}
