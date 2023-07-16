package com.company.blog.service.impl;

import com.company.blog.Exception.ResourceNotFound;
import com.company.blog.entities.Category;
import com.company.blog.entities.Post;
import com.company.blog.entities.User;
import com.company.blog.payloads.PostResponse;
import com.company.blog.repository.CategoryRepo;
import com.company.blog.repository.PostRepo;
import com.company.blog.repository.UserRepository;
import com.company.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return postRepo.save(newPost);
    }

    @Override
    public List<Post> getPostByUser(long id) {

        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFound("User Not Found with User Id = "+id));
        List<Post> posts = postRepo.findByUser(user);
        return posts;
    }

    @Override
    public List<Post> getPostByCategory(long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFound("Category not found with the id = "+ categoryId));

        List<Post> posts = postRepo.findByCategory(category);
        return posts;

    }

    @Override
    public String deletePostById(long postId) {
        Post post = postRepo.findById(postId).orElse(null);
        if(post != null){
            postRepo.deleteById(postId);
        }else throw new ResourceNotFound("Post Not Found with id = "+ postId);

//        postRepo.deleteById(post);
        return "deleted succesfull";
    }

    @Override
    public Post updatePost(Post post, long postId) {

        Post postupdate = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFound("Post not found with id = "+ postId));
        if(postupdate!=null){
            if(post.getPostTitle()!=null){
                postupdate.setPostTitle(post.getPostTitle());
            }

            if(post.getPostContent()!=null){
                postupdate.setPostContent(post.getPostContent());
            }
        }
        return postRepo.save(postupdate);
    }

    @Override
    public PostResponse getAllPost(int pageNumber, int pageSize, String sortBy, String sortDir) {
//        int pageSize = 5;
//        int pageNumber = 1;

        Sort sort = null;
        if(sortDir.equalsIgnoreCase("asc")){
            sort = Sort.by(sortBy).ascending();
        }else {
            sort = Sort.by(sortBy).descending();
        }

        Pageable pageable = PageRequest.of(pageNumber,pageSize, sort);

        Page<Post> pagePost = postRepo.findAll(pageable);

        List<Post> allPosts = pagePost.getContent();

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(allPosts);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements((int) pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());

//        return postRepo.findAll();
        return postResponse;
    }

    @Override
    public Post getPostById(long postId) {
        return postRepo.findById(postId).orElseThrow(()->new ResourceNotFound("Post not found with id = "+ postId));
    }


}
