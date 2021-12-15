package com.example.blogapp.controller;

import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.Post;
import com.example.blogapp.exception.PostErrorException;
import com.example.blogapp.service.CommentService;
import com.example.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Post createPost(@RequestBody PostDto postDto){

        return postService.createPost(postDto);
    }

    @GetMapping
    public List<Post> fetchAllPost(){
        return postService.fetchAllPost();
    }


    @GetMapping("/{id}")
    public Post fetchPostById(@PathVariable Long id){
        return postService.fetchPostById(id);
    }

    @PutMapping("/{id}")
   public Post updatePost(@PathVariable Long id, @RequestBody PostDto postDto) throws PostErrorException {
     return postService.updatePost(id,postDto);
   }

   @DeleteMapping("/{id}")
   public String deletePost(@PathVariable Long id){
       postService.deletePostById(id);
        return "Post with id " + id + " is successfully deleted";
   }
}
