package com.example.blogapp.repository;

import com.example.blogapp.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    private Post post;

    @BeforeEach
    void setUp() {
        post = new Post();
    }

    @Test
    void savePost(){
        postRepository.save(post);
        Post postDb = postRepository.findById(post.getId()).get();
        assertEquals(1, postDb.getId());
    }
}