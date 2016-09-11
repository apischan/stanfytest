package com.apischan.stanfytest;

import com.apischan.stanfytest.guice.DatabaseModule;
import com.apischan.stanfytest.guice.ServiceModule;
import com.apischan.stanfytest.route.RouterChain;
import lombok.extern.slf4j.Slf4j;
import ratpack.guice.Guice;
import ratpack.server.RatpackServer;

@Slf4j
public class Main {
    public static void main(String... args) throws Exception {
        log.info("Starting the application....");
        RatpackServer.start(server ->
                server.registry(
                        Guice.registry(bindings -> {
                            bindings.module(ServiceModule.class);
                            bindings.module(DatabaseModule.class);
                        })
                ).handlers(new RouterChain())
        );
    }
}
