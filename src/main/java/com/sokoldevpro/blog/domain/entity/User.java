package com.sokoldevpro.blog.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
@Entity @Table(name = "user")
public class User extends PersistentEntity {

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(length = 60)
    private String password;

    @Column(length = 100)
    private String fullName;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<>();

    public User(Long id, String username, String fullName) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
    }
}