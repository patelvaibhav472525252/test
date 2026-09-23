package com.microservice2.controller;

import com.microservice2.client.WelcomeClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ms2")
public class MicroService2Controller {

    private final WelcomeClient welcomeClient;

    public MicroService2Controller(WelcomeClient welcomeClient) {
        this.welcomeClient = welcomeClient;
    }

    @GetMapping("/call")
    public String getMessageFromMicroService1() {
        return welcomeClient.getMessage();
    }

    @PostMapping("/hello")
    public String hello(@RequestParam("x") String x) {
        return welcomeClient.getHello(x);
    }
}