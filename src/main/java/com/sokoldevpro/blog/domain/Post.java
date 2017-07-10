package com.sokoldevpro.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Post extends PersistentEntity {

    private String title;
    private String body;
    private User author;
    private Date date;

    public Post(Long id, String title, String body, User author, Date date) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.date = date;
    }
}
