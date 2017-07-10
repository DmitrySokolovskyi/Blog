package com.sokoldevpro.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data @NoArgsConstructor
@Table (name = "post") @EqualsAndHashCode(callSuper = true)
public class Post extends PersistentEntity {

    @Column(nullable = false, length = 300)
    private String title;

    @Column(nullable = false) @Lob
    private String body;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User author;

    @Column(nullable = false)
    private Date date = new Date();

    public Post(Long id, String title, String body, User author, Date date) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.date = date;
    }
}
