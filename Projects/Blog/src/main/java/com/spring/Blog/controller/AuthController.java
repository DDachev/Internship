package com.spring.Blog.controller;

import com.spring.Blog.model.User;
import com.spring.Blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

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
    public User register(@RequestBody User user) {
      return authService.register(user);
    }

    @PostMapping
    @RequestMapping(path = "login")
    public User login(String email, String password) {
        return authService.login(email, password);
    }
}
