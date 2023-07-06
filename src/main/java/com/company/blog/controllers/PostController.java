package com.company.blog.controllers;

import com.company.blog.entities.Post;
import com.company.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/users/{userId}/category/{categoryId}/post")
    public Post createPost(@PathVariable("userId")long id, @PathVariable("categoryId")long categoryId ,@RequestBody Post post){

        return postService.createPost(id,categoryId,post);
    }

    @GetMapping("/users/{userId}/posts")
    public List<Post> getPostByUser(@PathVariable("userId")long id){
        return postService.getPostByUser(id);
    }
}
