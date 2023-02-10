package com.backend.exercise.serviceImpl;

import com.backend.exercise.dto.PostDto;
import com.backend.exercise.exception.ResourceNotFoundException;
import com.backend.exercise.model.Post;
import com.backend.exercise.repository.PostRepository;
import com.backend.exercise.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        post.setTimestamp(LocalDateTime.now());
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll().stream()
                .sorted(Comparator.comparing(Post::getTimestamp).reversed()).collect(Collectors.toList());
    }

    @Override
    public Post getPostById(long id) {
        return findPost(id);
    }

    @Override
    public Post updatePost(PostDto postDto, long id) {
        Post postToUpdate = findPost(id);
        postToUpdate.setId(id);
        postToUpdate.setTitle(postDto.getTitle());
        postToUpdate.setCategoryId(postDto.getCategoryId());
        postToUpdate.setTimestamp(LocalDateTime.now());

        return savePost(postToUpdate);
    }

    @Override
    public void deletePostById(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void deleteAllPosts() {
        postRepository.deleteAll();
    }

    private Post findPost(long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
    }
}
