package com.example.blogapp.controller;


import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.DatabaseFile;
import com.example.blogapp.entity.Response;
import com.example.blogapp.service.DatabaseFileService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

    @Autowired
    private DatabaseFileService fileStorageService;


    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        DatabaseFile fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName.getFileName())
                .toUriString();

        return new Response(fileName.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/postToUploadedFile")
    public void postUnderFile(@RequestBody PostDto postDto,@RequestParam("name") String name, DatabaseFile databaseFile){
       fileStorageService.postUnderUploadedFile(postDto,name, databaseFile);
    }
}
