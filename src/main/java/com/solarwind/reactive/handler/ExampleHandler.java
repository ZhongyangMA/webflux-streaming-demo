package com.solarwind.reactive.handler;

import com.solarwind.reactive.dao.UserRepository;
import com.solarwind.reactive.model.User;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Zhongyang MA
 * Date: 2018/4/11
 * Time: 17:28
 */
@Component
public class ExampleHandler {

    @Autowired
    private UserRepository userRepository;

    public Mono<String> test1() {
        return Mono.just("test1: return a simple string");
    }

    public Flux<Pair> test2() {
        Flux<Pair> flux = Flux
                .interval(Duration.ofMillis(1000))
                .map(i -> {
                    String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    return new Pair(now, i);
                });
        return flux;
    }

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

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userRepository.findAll(), User.class);
    }

}
