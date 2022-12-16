package com.mapenda.architecture_netflix_uber.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxController {

    @GetMapping("/flux")
    public Flux<String> ga4ghFlux()
    {
        return Flux.just("Uber", "Netflix")
                .delayElements(Duration.ofSeconds(1))
                .log();

    }

    @GetMapping(value="/stream", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<String> ga4ghFluxStream()
    {
        return Flux.just("Uber", "Netflix")
                .delayElements(Duration.ofSeconds(1))
                .log();

    }
}