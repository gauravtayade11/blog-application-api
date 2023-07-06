package com.company.blog.repository;

import com.company.blog.entities.Post;
import com.company.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByUser(User user);
}
