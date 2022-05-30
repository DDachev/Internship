package com.spring.Blog.service;

import com.spring.Blog.repository.UserRepository;
import com.spring.Blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(users, HttpStatus.OK);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}