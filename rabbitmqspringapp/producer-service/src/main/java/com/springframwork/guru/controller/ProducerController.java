package com.springframwork.guru.controller;

import com.springframwork.guru.domain.User;
import com.springframwork.guru.service.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProducerController {


    private RabbitMqSender rabbitMqSender;

    @Autowired
    public ProducerController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    @Value("${app.message}")
    private String message;

    @PostMapping(value = "user")
    public String publishUserDetails(@RequestBody User user) {
        rabbitMqSender.send(user);
        return message;
    }
}
