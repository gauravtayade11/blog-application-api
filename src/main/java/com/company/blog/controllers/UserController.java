package com.company.blog.controllers;


import com.company.blog.entities.User;
import com.company.blog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    // add users
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    // update user
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User updateUserById(@PathVariable("id")Long id,@RequestBody User user){
        return userService.updateUser(user, id);
    }

    // get user by id
    @GetMapping("users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("users/{id}")
    public void deleteUserById(@PathVariable("id")Long id){
        userService.deleteUser(id);
    }
}
