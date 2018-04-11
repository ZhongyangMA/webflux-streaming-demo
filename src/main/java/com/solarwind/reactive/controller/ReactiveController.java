package com.solarwind.reactive.controller;

import com.solarwind.reactive.handler.ExampleHandler;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * User: Zhongyang MA
 * Date: 2018/4/4
 * Time: 12:07
 */
@RestController
@RequestMapping("/annotated")
public class ReactiveController {
    @Autowired
    private ExampleHandler exampleHandler;

    // Example of returning a simple string to your browser
    @GetMapping("/test1")
    public Mono<String> test1() {
        return exampleHandler.test1();
    }

    // The server will push messages line by line to your browser - scrolling effect on your browser
    @GetMapping(value = "/test2", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Pair> test2() {
        return exampleHandler.test2();
    }

}
