package com.backend.exercise.controller;

import com.backend.exercise.dto.PostDto;
import com.backend.exercise.model.Post;
import com.backend.exercise.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts/")
    public Post createPost(@RequestBody PostDto postDto) {
        return postService.savePost(createNewPostFromPostDto(postDto));
    }

    @GetMapping("/posts/")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable("id") long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/posts/{id}")
    public Post updatePostById(@PathVariable ("id")  long id,
                               @RequestBody PostDto postDto) {
        return postService.updatePost(postDto, id);
    }

    @DeleteMapping("/posts/{id}")
    public String deletePostById(@PathVariable("id") long id) {
        postService.deletePostById(id);
        return "Post with id : "+ id + " deleted successfully !";
    }

    @DeleteMapping("/posts/")
    public String deleteAllPosts() {
        postService.deleteAllPosts();
        return "All posts deleted successfully !";
    }

    private Post createNewPostFromPostDto(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContents(postDto.getContents());
        post.setCategoryId(postDto.getCategoryId());
        return post;
    }
}
