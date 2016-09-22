package com.apischan.stanfytest.route;

import com.apischan.stanfytest.handler.candidate.AllCandidatesHandler;
import com.apischan.stanfytest.handler.candidate.CandidateByIdHandler;
import com.apischan.stanfytest.handler.candidate.StoreCandidateHandler;
import com.apischan.stanfytest.handler.skill.SkillByIdHandler;
import com.apischan.stanfytest.handler.skill.SkillByQueryHandler;
import lombok.extern.slf4j.Slf4j;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.RequestLogger;

@Slf4j
public class RouterChain implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain
                .all(RequestLogger.ncsa(log))
                // candidate endpoints
                .get("candidates", AllCandidatesHandler.class)
                .get("candidates/:id", CandidateByIdHandler.class)
                .post("candidate", StoreCandidateHandler.class)

                // skill endpoints
                .get("skills", SkillByQueryHandler.class)
                .get("skills/:id", SkillByIdHandler.class);
    }

}
