package com.sokoldevpro.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Post extends PersistentEntity {

    private String title;
    private String body;
    private User author;
    private Date date;
}
