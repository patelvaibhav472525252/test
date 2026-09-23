package com.microservice2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MICROSERVICE1")
public interface WelcomeClient {

    @GetMapping("/api/v1/message")
    String getMessage();

    @PostMapping("/api/v1/hello")
    String getHello(@RequestParam("x") String x);
}