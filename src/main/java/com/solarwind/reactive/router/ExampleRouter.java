package com.solarwind.reactive.router;

import com.solarwind.reactive.handler.ExampleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Zhongyang MA
 * Date: 2018/4/11
 * Time: 17:24
 */
@Configuration
public class ExampleRouter {

    @Bean
    public RouterFunction<ServerResponse> route1(ExampleHandler exampleHandler) {
        return RouterFunctions.route(RequestPredicates
                .GET("/functional/test1")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), exampleHandler::funcTest1);
    }

    @Bean
    public RouterFunction<ServerResponse> route2(ExampleHandler exampleHandler) {
        return RouterFunctions.route(RequestPredicates
                .GET("/functional/test2")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), exampleHandler::funcTest2);
    }

}
