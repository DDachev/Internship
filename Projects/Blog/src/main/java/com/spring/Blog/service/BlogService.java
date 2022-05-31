package com.spring.Blog.service;

import com.spring.Blog.model.Blog;
import com.spring.Blog.model.User;
import com.spring.Blog.repository.BlogRepository;
import com.spring.Blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class BlogService {
    @Autowired
    private final BlogRepository blogRepository;
    @Autowired
    private final UserRepository userRepository;

    public ResponseEntity<List<Blog>> getBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    public ResponseEntity<Blog> addBlog(Blog blog, String username) {
        if (userRepository.findByUsername(username) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = userRepository.findByUsername(username);
        blog.setUser(user);
        blogRepository.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}