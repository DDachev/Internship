package com.spring.Blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 100, message = "Username must be between 3 and 100 characters")
    @Column(name = "USER_NAME")
    private String username;

    @Email
    @NotBlank(message = "Email is required")
    @Size(min = 3, max = 255, message = "Email must be between 3 and 255 characters")
    @Column(nullable = false)
    private String email;
    @Size(min = 3, max = 72, message = "Password must be between 3 and 72 characters")
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String password;

    private boolean logged = false;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

