package org.springframework.guru.restdocsdemo.controller;

import org.springframework.guru.restdocsdemo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    List<User> users = Arrays.asList(
            new User(001,"John","john@gmail.com"),
             new User(002,"Henry","henry@gmail.com")
    );

    @GetMapping("/users")
    public List<User> getUsers(){
        return users;
    }
}
