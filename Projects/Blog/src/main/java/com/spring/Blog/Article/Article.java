package com.spring.Blog.Article;

import javax.persistence.*;

@Entity
@Table
public class Article {
    @Id
    @SequenceGenerator(
            name="article_seq",
            sequenceName="article_seq",
            allocationSize=1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="article_seq"
    )
    private long id;
    private String title;
    private String content;
    private long image_id;
    private long blog_id;
}
