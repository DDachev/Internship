package com.spring.Blog.service;

import com.spring.Blog.model.User;
import com.spring.Blog.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    @Autowired
    private final AuthRepository authRepository;

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
