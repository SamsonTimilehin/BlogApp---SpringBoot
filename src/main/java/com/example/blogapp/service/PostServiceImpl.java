package com.example.blogapp.service;

import com.example.blogapp.dto.CommentDto;
import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.Comment;
import com.example.blogapp.entity.Post;
import com.example.blogapp.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Post createPost(PostDto postDto) {

        Post post;
        post = modelMapper.map(postDto, Post.class);

        return postRepository.save(post);
    }

    @Override
    public List<Post> fetchAllPost() {

        return postRepository.findAll();
    }

    @Override
    public Post findPostByTitle(String postTitle) {
        return postRepository.findPostByTitle(postTitle);
    }

    @Override
    public Comment getComments(CommentDto commentDto) {

        return commentService.addComment(commentDto);
    }

    @Override
    public Post updatePost(Long id, PostDto postDto) {

        if(postDto == null){
            throw new IllegalArgumentException("Post cannot be empty");
        }

        Post postDB = postRepository.findById(id).get();

        modelMapper.map(postDto, postDB);
        postRepository.save(postDB);
        return postDB;
    }

    @Override
    public Post fetchPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
