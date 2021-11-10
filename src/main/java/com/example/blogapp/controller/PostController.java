package com.example.blogapp.controller;

import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.Post;
import com.example.blogapp.service.CommentService;
import com.example.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Post createPost(@RequestBody PostDto postDto){

        return postService.createPost(postDto);
    }

    @GetMapping
    public List<Post> fetchAllPost(){
        return postService.fetchAllPost();
    }



}
