package com.example.blogapp.controller;

import com.example.blogapp.entity.Post;
import com.example.blogapp.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import javax.net.ssl.SSLEngineResult;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class PostControllerTest {

    @Mock
    private PostService postService;

    private Post post;

    @InjectMocks
    private PostController postController;

    @InjectMocks
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        post = new Post();
    }

    @Test
    void TestThatAUserCanPost(){

        //mockMvc.perform(post("/post")).andExpect(status().isOk());
    }

}