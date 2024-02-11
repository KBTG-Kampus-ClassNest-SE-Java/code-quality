package com.werockstar.architecturetesting.controller;

import com.werockstar.architecturetesting.repository.Message;
import com.werockstar.architecturetesting.service.PingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    private final PingService pingService;

    public PingController(PingService pingService) {
        this.pingService = pingService;
    }

    @GetMapping("/ping")
    public Message ping() {
        return pingService.ping();
    }
}
