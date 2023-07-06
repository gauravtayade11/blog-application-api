package com.company.blog.services;

import com.company.blog.entities.Post;

import java.util.List;

public interface PostService {
    Post createPost(long id, long categoryId, Post post);

    List<Post> getPostByUser(long id);
}
