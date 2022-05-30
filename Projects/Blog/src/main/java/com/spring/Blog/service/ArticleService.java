package com.spring.Blog.service;

import com.spring.Blog.model.Article;
import com.spring.Blog.model.Blog;
import com.spring.Blog.model.User;
import com.spring.Blog.repository.ArticleRepository;
import com.spring.Blog.repository.BlogRepository;
import com.spring.Blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private final ArticleRepository articleRepository;
    @Autowired
    private final BlogRepository blogRepository;
    @Autowired
    private final UserRepository userRepository;

    public ArticleService(ArticleRepository articleRepository, BlogRepository blogRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public ResponseEntity<Article> addArticle(Article article, String username, long blogId) {
        if (userRepository.findByUsername(username) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = userRepository.findByUsername(username);
        Blog blog = blogRepository.findById(blogId).orElse(null);

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setUser(user);
        blog.addArticle(article);
        article.setBlog(blog);
        articleRepository.save(article);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }
}
