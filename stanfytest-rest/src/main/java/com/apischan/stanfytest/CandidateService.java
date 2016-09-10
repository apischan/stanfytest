package com.apischan.stanfytest;

import com.apischan.stanfytest.entity.Candidate;

import java.util.Arrays;

public class CandidateService {

    Candidate getCandidate() {
        return new Candidate(
                "Vasya",
                Arrays.asList("html", "css", "javascript")
        );
    }

}
