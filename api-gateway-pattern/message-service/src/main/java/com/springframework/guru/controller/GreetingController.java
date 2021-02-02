package com.springframework.guru.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/version1/")
class GreetingController {


    @GetMapping("message")
    public String getMessage() {
        return "Hello from REST API";
    }
}