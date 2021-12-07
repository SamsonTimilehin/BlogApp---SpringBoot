package com.example.blogapp.repository;

import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional
    void savePost(){

        PostDto postDto = PostDto.builder()
                .title("Common mistakes")
                .body("Discussing common errors").build();

        Post post = Post.builder()
                .title(postDto.getTitle())
                .body(postDto.getBody()).build();
        postRepository.save(post);

        String postTitle = "Common mistakes";

        Post expected = postRepository.findPostByTitle(post.getTitle());
        assertEquals(expected, postRepository.findPostByTitle(postTitle));
    }
}