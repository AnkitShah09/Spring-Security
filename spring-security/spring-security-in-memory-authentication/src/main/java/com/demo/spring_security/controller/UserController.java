package com.demo.spring_security.controller;

import com.demo.spring_security.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> getSampleUsers() {
        return List.of(
                User.builder().id(1L).name("User1").build(),
                User.builder().id(2L).name("User2").build(),
                User.builder().id(3L).name("User3").build()
        );
    }

    @GetMapping
    public List<User> getAllUsers() {
        return getSampleUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return getSampleUsers().stream().filter(user -> user.getId() == id).findAny().get();
    }
}
