package com.company.blog.services;

import com.company.blog.entities.Post;
import com.company.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {
    Post createPost(long id, long categoryId, Post post);

    List<Post> getPostByUser(long id);

    List<Post> getPostByCategory(long categoryId);

    String deletePostById(long postId);

    Post updatePost(Post post,long postId);

//    List<Post> getAllPost(int pageNumber, int pageSize);
    PostResponse getAllPost(int pageNumber, int pageSize, String sortBy, String sortDir);

    Post getPostById(long postId);
}
