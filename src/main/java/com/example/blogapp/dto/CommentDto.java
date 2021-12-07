package com.example.blogapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {

    private String postTitle;
    private String comment;
    private String commenter;
}
