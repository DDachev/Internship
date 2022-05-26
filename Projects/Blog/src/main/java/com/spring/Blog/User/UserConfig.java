package com.spring.Blog.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User user1 = new User("user1", "user1mail@gmail.com", "user1password");
            User user2 = new User("user2", "user2mail@gmail.com", "user2password");
            repository.saveAll(List.of(user1, user2));
        };
    }
}