package com.spring.Blog.service;

import com.spring.Blog.model.User;
import com.spring.Blog.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public User register(User user) {
        return authRepository.save(user);
    }

    public User login(String email, String password) {
        User user = authRepository.findUserByEmail(email);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
