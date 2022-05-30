package com.spring.Blog.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    //@OneToOne
    //@JoinColumn(name = "image_id")
    private long image_id;

    //@ManyToOne
    //@JoinColumn(name = "blog_id")
    private long blog_id;
}
