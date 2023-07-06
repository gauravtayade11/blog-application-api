package com.company.blog.services;

import com.company.blog.entities.Post;
import com.company.blog.entities.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);

    User updateUser(User user, Long userId);
    User getUserById(long userId);
    List<User> getAllUsers();
    String deleteUser(long userId);

}
