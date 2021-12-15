package com.example.blogapp.service;

import com.example.blogapp.dto.CommentDto;
import com.example.blogapp.entity.Comment;
import com.example.blogapp.exception.PostErrorException;

public interface CommentService {

    Comment addComment(CommentDto commentDto) throws PostErrorException;
}
