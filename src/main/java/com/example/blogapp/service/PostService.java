package com.example.blogapp.service;

import com.example.blogapp.dto.CommentDto;
import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.Comment;
import com.example.blogapp.entity.Post;

import java.util.List;

public interface PostService {

    Post createPost(PostDto postDto);

    List<Post> fetchAllPost();

    Post findPostByTitle(String postTitle);

    Comment getComments(CommentDto commentDto);
}
