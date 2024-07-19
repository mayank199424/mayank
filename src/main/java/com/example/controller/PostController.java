package com.example.controller;


import com.example.entity.Post;
import com.example.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//post-http://localhost:8080/api/v1/posts/create

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostRepository postRepository;//to connect with repository

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        Post savedPost = postRepository.save(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }
}
