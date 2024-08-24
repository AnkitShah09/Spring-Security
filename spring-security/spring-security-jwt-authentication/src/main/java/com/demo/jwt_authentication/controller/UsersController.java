package com.demo.jwt_authentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @GetMapping("/public")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public String getHomePage() {
        return "This is home page!!!";
    }

    @GetMapping("/private")
    public List<String> getUsers() {
        return List.of("u1", "u2", "u3");
    }
}
