package com.example.blogapp.repository;

import com.example.blogapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

     Post findPostByTitle(String postTitle);
}
