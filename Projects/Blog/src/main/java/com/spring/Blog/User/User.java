package com.spring.Blog.User;

import com.spring.Blog.Blog.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String user_name;
    private String email;
    private String password;

    @OneToMany
    private List<Blog> blogs;

    public User(String user_name, String email, String password) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }
}

