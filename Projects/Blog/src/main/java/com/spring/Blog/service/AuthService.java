package com.spring.Blog.service;

import com.spring.Blog.model.User;
import com.spring.Blog.repository.AuthRepository;
import com.spring.Blog.repository.UserRepository;
import com.spring.Blog.utility.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.spring.Blog.utility.UserValidator.*;
import static com.spring.Blog.utility.ValidationMessages.SUCCESS;


@Service
@Getter
@Setter
@AllArgsConstructor
public class AuthService {
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> register(@RequestBody User user) {
        ValidationMessages result = (isValidName())
                .and(isValidEmail())
                .and(isValidPassword())
                .apply(user);

        if (result != SUCCESS) {
            return ResponseEntity.badRequest().body(result.getMessage());
        }
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        try {
            authRepository.save(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<String> login(@RequestBody User user) {
        User userDb = userRepository.findByEmail(user.getEmail());
        if (userDb == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        if (user.getPassword().equals(userDb.getPassword())) {
            userDb.setLogged(true);
            userRepository.save(userDb);
            return new ResponseEntity<>("User logged in!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Wrong password",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<User> logout(@RequestBody User user) {
        User user1 = userRepository.findByEmail(user.getEmail());
        if (user.isLogged()) {
            user.setLogged(false);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
