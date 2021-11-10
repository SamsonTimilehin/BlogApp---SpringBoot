package com.example.blogapp.controller;

import com.example.blogapp.dto.CommentDto;
import com.example.blogapp.entity.Comment;
import com.example.blogapp.service.CommentService;
import com.example.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @PostMapping
    public Comment addComment(@RequestBody CommentDto commentDto){
        return postService.getComments(commentDto);
    }
}
