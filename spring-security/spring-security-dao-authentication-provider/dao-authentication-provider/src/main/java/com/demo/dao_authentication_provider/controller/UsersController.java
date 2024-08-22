package com.demo.dao_authentication_provider.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @GetMapping("/home")
    @PreAuthorize("hasAnyAuthority('USER')")
    public String getHomePage() {
        return "This is home page!!!";
    }

    @GetMapping("/users")
    public List<String> getUsers() {
        return List.of("u1", "u2", "u3");
    }
}
