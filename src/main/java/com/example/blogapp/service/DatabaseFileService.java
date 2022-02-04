package com.example.blogapp.service;


import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.DatabaseFile;
import org.springframework.web.multipart.MultipartFile;

public interface DatabaseFileService {

    DatabaseFile storeFile(MultipartFile file);

    void postUnderUploadedFile(PostDto postDto, DatabaseFile databaseFile);
}
