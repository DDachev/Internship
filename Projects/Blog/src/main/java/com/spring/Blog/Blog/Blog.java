package com.spring.Blog.Blog;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @SequenceGenerator(
            name="blog_seq",
            sequenceName="blog_seq",
            allocationSize=1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="blog_seq"
    )

    private long id;
    private String title;
    private long user_id;


}
