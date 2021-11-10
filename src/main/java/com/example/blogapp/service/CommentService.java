package com.example.blogapp.service;

import com.example.blogapp.dto.CommentDto;
import com.example.blogapp.entity.Comment;

public interface CommentService {

    Comment addComment(CommentDto commentDto);
}
