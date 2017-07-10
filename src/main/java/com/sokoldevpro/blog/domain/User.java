package com.sokoldevpro.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends PersistentEntity {

    private String username;
    private String password;
    private String fullName;

    private Set<Post> posts ;

    public User(Long id, String username, String fullName) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
    }
}
