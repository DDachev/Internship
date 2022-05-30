package com.spring.Blog.service;

import com.spring.Blog.model.Blog;
import com.spring.Blog.model.User;
import com.spring.Blog.repository.BlogRepository;
import com.spring.Blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;


    public BlogService(BlogRepository blogRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    public ResponseEntity addBlog(Blog blog, String username) {
        User user = userRepository.findByUsername(username);
        blog.setUser(user);
        blogRepository.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
