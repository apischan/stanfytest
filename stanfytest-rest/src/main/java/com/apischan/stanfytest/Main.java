package com.apischan.stanfytest;

import com.apischan.stanfytest.entity.Candidate;
import com.apischan.stanfytest.entity.Candidate2;
import lombok.extern.slf4j.Slf4j;
import ratpack.server.RatpackServer;
import static ratpack.jackson.Jackson.*;

@Slf4j
public class Main {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .handlers(chain -> chain
                        .get(ctx -> ctx.render("Hello World!"))
                        .get("candidate", ctx -> {
                            Candidate candidate = new CandidateService().getCandidate();
                            ctx.render(json(candidate));
                        })
                )
        );
    }
}
