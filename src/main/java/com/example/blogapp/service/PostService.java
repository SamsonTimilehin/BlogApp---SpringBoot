package com.example.blogapp.service;

import com.example.blogapp.dto.CommentDto;
import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.Comment;
import com.example.blogapp.entity.Post;
import com.example.blogapp.exception.PostErrorException;

import java.util.List;

public interface PostService {

    Post createPost(PostDto postDto);

    List<Post> fetchAllPost();

    Post findPostByTitle(String postTitle);

    Comment getComments(CommentDto commentDto) throws PostErrorException;

    Post updatePost(Long id, PostDto postDto) throws PostErrorException;

    Post fetchPostById(Long id);

    void deletePostById(Long id);
}
