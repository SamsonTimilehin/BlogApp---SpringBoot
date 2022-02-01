package com.example.blogapp.service;


import com.example.blogapp.entity.DatabaseFile;
import org.springframework.web.multipart.MultipartFile;

public interface DatabaseFileService {

    DatabaseFile storeFile(MultipartFile file);
}
