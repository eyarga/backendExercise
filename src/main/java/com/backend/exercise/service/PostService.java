package com.backend.exercise.service;

import com.backend.exercise.dto.PostDto;
import com.backend.exercise.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostService {

    // Create post
    Post savePost(Post post);

    // Get all post
    List<Post> getAllPosts();

    // Get post by id
    Post getPostById(long id);

    // Update post by id
    Post updatePost(PostDto postDto, long id);

    // Delete post by id
    void deletePostById(long id);

    // Delete all posts
    void deleteAllPosts();
}
