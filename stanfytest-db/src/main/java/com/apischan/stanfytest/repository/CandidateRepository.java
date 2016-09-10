package com.apischan.stanfytest.repository;
//import static test.generated.Tables.*;
import com.apischan.stanfytest.dto.CandidateDto;
import com.apischan.stanfytest.repository.util.ConnectionProvider;
import com.google.inject.Inject;

import java.util.ArrayList;

public class CandidateRepository {

    private ConnectionProvider connectionProvider;

    @Inject
    private CandidateRepository(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public CandidateDto getCandidateById() {
        return new CandidateDto("aa", "bb", new ArrayList<>());
    }

}
