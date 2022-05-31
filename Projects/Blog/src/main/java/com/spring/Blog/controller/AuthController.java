package com.spring.Blog.controller;

import com.spring.Blog.model.User;
import com.spring.Blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/auth/")

public class AuthController {
    @Autowired
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    @RequestMapping(path = "register")
    public ResponseEntity<String> register( @RequestBody User user) {
      return authService.register(user);
    }

    @PostMapping
    @RequestMapping(path = "login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return authService.login(user);
    }

    @PostMapping
    @RequestMapping(path = "logout")
    public ResponseEntity<User> logout(@RequestBody User user) {
        return authService.logout(user);
    }
}
