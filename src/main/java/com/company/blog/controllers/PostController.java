package com.company.blog.controllers;

import com.company.blog.entities.Post;
import com.company.blog.payloads.PostResponse;
import com.company.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/post")
    public Post createPost(@RequestBody Post post,@PathVariable("userId")long id, @PathVariable("categoryId")long categoryId ){

        return postService.createPost(id,categoryId,post);
    }

    @GetMapping("/user/{userId}/posts")
    public List<Post> getPostByUser(@PathVariable("userId")long id){
        return postService.getPostByUser(id);
    }

    @GetMapping("/category/{categoryId}/posts")
    public List<Post> getPostByCategory(@PathVariable("categoryId") long categoryId){
        return postService.getPostByCategory(categoryId);
    }

    @DeleteMapping("/post/{postId}")

    public String deletePostById(@PathVariable("postId")long postId){
        return postService.deletePostById(postId);
    }

    @PutMapping("/post/{postId}")
    public Post updatePost(@RequestBody Post post,@PathVariable("postId") long postId){
        return postService.updatePost(post,postId);
    }

    @GetMapping("/posts")
    public PostResponse gettAllPost(
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "3",required = false)int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "postId",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir
    ){
         PostResponse allPost = postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
         return allPost;
    }

    @GetMapping("/post/{postId}")
    public Post getPostById(@PathVariable("postId")long postId){
        return postService.getPostById(postId);
    }
}
