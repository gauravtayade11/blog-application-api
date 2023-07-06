package com.company.blog.service.impl;

import com.company.blog.Exception.ResourceNotFound;
import com.company.blog.entities.Category;
import com.company.blog.entities.Post;
import com.company.blog.entities.User;
import com.company.blog.repository.CategoryRepo;
import com.company.blog.repository.PostRepo;
import com.company.blog.repository.UserRepository;
import com.company.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public Post createPost(long id, long categoryId, Post post) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFound("User not Found"));
        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFound("Category not Found"));

        Post newPost = new Post();

        newPost.setPostImageName("default.png");
        newPost.setAddedDate(new Date());
        newPost.setUser(user);
        newPost.setCategory(category);
        newPost.setPostTitle(post.getPostTitle());
        newPost.setPostContent(post.getPostContent());
        return newPost;
    }

    @Override
    public List<Post> getPostByUser(long id) {

        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFound("User Not Found"));
        List<Post> posts = postRepo.findByUser(user);
        return posts;
    }


}
