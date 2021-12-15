package com.example.blogapp.service;

import com.example.blogapp.dto.CommentDto;
import com.example.blogapp.entity.Comment;
import com.example.blogapp.entity.Post;
import com.example.blogapp.exception.PostErrorException;
import com.example.blogapp.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private PostService postService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommentRepository commentRepository;



    @Override
    public Comment addComment(CommentDto commentDto) throws PostErrorException {
        Post postDB = postService.findPostByTitle(commentDto.getPostTitle());
        if(postDB == null){
            throw new PostErrorException("Post title "+ commentDto.getPostTitle() + " does not exist");
        }
        Comment comment;
        comment = modelMapper.map(commentDto, Comment.class);
        comment.setPost(postDB);
        postDB.getComments().add(comment);
        commentRepository.save(comment);
        return comment;
    }
}
