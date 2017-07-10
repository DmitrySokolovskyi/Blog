package com.sokoldevpro.blog.service;

import com.sokoldevpro.blog.domain.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
}
