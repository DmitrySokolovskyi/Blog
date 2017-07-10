package com.sokoldevpro.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Set;

@Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class User extends PersistentEntity {

    private String username;
    private String password;
    private String fullName;

    private Set<Post> posts ;
}
