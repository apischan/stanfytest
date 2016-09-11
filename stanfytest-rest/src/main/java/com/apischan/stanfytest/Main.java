package com.apischan.stanfytest;

import com.apischan.stanfytest.guice.DatabaseModule;
import com.apischan.stanfytest.guice.ServiceModule;
import lombok.extern.slf4j.Slf4j;
import ratpack.guice.Guice;
import ratpack.server.RatpackServer;

import static com.apischan.stanfytest.handler.CandidateHandlers.*;
import static com.apischan.stanfytest.handler.SkillHandlers.*;

@Slf4j
public class Main {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .registry(Guice.registry(bindings -> {
                    bindings.module(ServiceModule.class);
                    bindings.module(DatabaseModule.class);
                }))
                .handlers(chain -> chain
                        // candidate endpoints
                        .get("candidate", AllCandidatesHandler.class)
                        .get("candidate/:id", CandidateByIdHandler.class)

                        // skill endpoints
                        .get("skill", SkillByQueryHandler.class)
                        .get("skill/:id", SkillByIdHandler.class)
                )
        );
    }
}
