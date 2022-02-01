package com.example.blogapp.controller;

import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.Post;
import com.example.blogapp.exception.PostErrorException;
import com.example.blogapp.service.CommentService;
import com.example.blogapp.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Operation(summary = "This endpoint is used to save user's post to mysql database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "It will return post object")

    })
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
