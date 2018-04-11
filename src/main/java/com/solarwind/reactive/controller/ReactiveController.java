package com.solarwind.reactive.controller;

import javafx.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Zhongyang MA
 * Date: 2018/4/4
 * Time: 12:07
 */
@RestController
@RequestMapping("/annotated")
public class ReactiveController {

    // Example of returning a simple string to your browser
    @GetMapping("/test1")
    public Mono<String> test1() {
        return Mono.just("test1");
    }

    // The server will push messages line by line to your browser - scrolling effect on your browser
    @GetMapping(value = "/test2", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Pair> test2() {
        Flux<Pair> flux = Flux
                .interval(Duration.ofMillis(1000))
                .map(i -> {
                    String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    return new Pair(now, i);
                });
        return flux;
    }

}
