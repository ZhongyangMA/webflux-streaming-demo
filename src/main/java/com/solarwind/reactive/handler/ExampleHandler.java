package com.solarwind.reactive.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * User: Zhongyang MA
 * Date: 2018/4/11
 * Time: 17:28
 */
@Component
public class ExampleHandler {

    public Mono<ServerResponse> funcTest1(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("funcTest1: WebFlux functional router."));
    }

    public Mono<ServerResponse> funcTest2(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("funcTest2: WebFlux functional router."));
    }

}
