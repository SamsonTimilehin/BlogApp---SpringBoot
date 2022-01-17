package com.example.blogapp.service;

import com.example.blogapp.entity.Post;
import com.example.blogapp.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private Post post;

    @BeforeEach
    void setUp() {

        post = new Post();
    }

    @Test
    void savePost(){
        postRepository.save(post);
        verify(postRepository).save(post);
    }
}