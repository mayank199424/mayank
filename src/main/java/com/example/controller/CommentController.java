package com.example.controller;

import com.example.entity.Comment;
import com.example.entity.Post;
import com.example.repository.CommentRepository;
import com.example.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")

public class CommentController {
   private CommentRepository commentRepository;

   private PostRepository postRepository;


    public CommentController(CommentRepository commentRepository,PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository=postRepository;
    }

@PostMapping
    public ResponseEntity<Comment> createComment(

            @RequestBody Comment comment,
            @RequestParam long postId  //bcoz we can not save a comment without knowledge of post
    ){

    Optional<Post> opPost = postRepository.findById(postId);
    Post post = opPost.get();
    comment.setPost(post);//pushing foreign key(to set foreign key in table)

     //return ResponseEntity.ok(commentRepository.save(comment));

   Comment savedcomment = commentRepository.save(comment);
    return new ResponseEntity<>(savedcomment, HttpStatus.CREATED);


}

//======================================================================================================

}


