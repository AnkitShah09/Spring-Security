package com.demo.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/home")
    public String homePage() {
        return "Home Page";
    }

    @GetMapping("/users")
    public List<String> getAllUsers() {
        return List.of("User-1", "User-2", "User-3");
    }
}
