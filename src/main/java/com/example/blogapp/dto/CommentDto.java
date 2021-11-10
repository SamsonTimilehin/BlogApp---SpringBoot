package com.example.blogapp.dto;

import lombok.Data;

@Data
public class CommentDto {

    private String postTitle;
    private String comment;
    private String commenter;
}
