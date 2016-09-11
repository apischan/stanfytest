package com.apischan.stanfytest.route;

import com.apischan.stanfytest.handler.CandidateHandlers;
import com.apischan.stanfytest.handler.SkillHandlers;
import ratpack.func.Action;
import ratpack.handling.Chain;

public class RouterChain implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain
                // candidate endpoints
                .get("candidates", CandidateHandlers.AllCandidatesHandler.class)
                .get("candidates/:id", CandidateHandlers.CandidateByIdHandler.class)
                .post("candidate", CandidateHandlers.StoreCandidateHandler.class)

                // skill endpoints
                .get("skills", SkillHandlers.SkillByQueryHandler.class)
                .get("skills/:id", SkillHandlers.SkillByIdHandler.class);
    }

}
