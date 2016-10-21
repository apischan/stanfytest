package com.apischan.stanfytest;

import com.apischan.stanfytest.guice.DatabaseModule;
import com.apischan.stanfytest.repository.CandidateRepository;
import com.apischan.stanfytest.repository.SkillRepository;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DatabaseModule());
        CandidateRepository candidateRepository = injector.getInstance(CandidateRepository.class);
        SkillRepository skillRepository = injector.getInstance(SkillRepository.class);
        System.out.println(candidateRepository.getAllCandidates());
//        CandidateDto candidate = CandidateDto.of(null, "Viktor", "Lepovski");
//        candidate.setSkills(Arrays.asList(
//                SkillDto.of(7, "git"),
//                SkillDto.of(1, "html"),
//                SkillDto.of(null, "haskell")
//        ));
//        candidateRepository.saveCandidate(candidate);
    }

}
