package com.spring.Blog.controller;

import com.spring.Blog.model.Blog;
import com.spring.Blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/")
public class BlogController {
    @Autowired
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    @PostMapping(path = "{username}/blog/add")
    public Blog addBlogToUser(@RequestBody Blog blog, @PathVariable("username") String username) {
        blogService.addBlog(blog, username);
        return blog;
    }
}
