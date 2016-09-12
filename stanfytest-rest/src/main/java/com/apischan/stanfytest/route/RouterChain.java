package com.apischan.stanfytest.route;

import com.apischan.stanfytest.handler.CandidateHandlers;
import com.apischan.stanfytest.handler.SkillHandlers;
import lombok.extern.slf4j.Slf4j;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.RequestLogger;

import static com.apischan.stanfytest.handler.CandidateHandlers.*;
import static com.apischan.stanfytest.handler.SkillHandlers.*;

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
