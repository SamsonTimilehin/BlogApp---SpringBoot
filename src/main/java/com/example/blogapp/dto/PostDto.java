package com.example.blogapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {

    private String title;
    private String body;
}
