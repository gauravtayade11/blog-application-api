package com.company.blog.service.impl;

import com.company.blog.Exception.ResourceNotFound;
import com.company.blog.entities.Post;
import com.company.blog.entities.User;
import com.company.blog.repository.UserRepository;
import com.company.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long userId) {
        User user1 = userRepository.findById(userId).get();
        if(userId != null){
            if(user.getName()!= null){
            user1.setName(user.getName());
            }
            if(user.getEmail()!= null){
                user1.setEmail(user.getEmail());
            }
            if(user.getAbout()!= null){
                user1.setAbout(user.getAbout());
            }

        }
        return userRepository.save(user1);
    }

    @Override
    public User getUserById(long userId) {
//        return userRepository.findById(userId).get();
        return userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFound("No User is Found with id = "+ userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user != null){
            userRepository.deleteById(userId);
            return "User deleted Successfully";
        }else{
            throw new ResourceNotFound("No User is Found with id = "+ userId);
        }
    }


}
