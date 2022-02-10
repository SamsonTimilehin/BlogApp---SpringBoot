package com.example.blogapp.service;

import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.DatabaseFile;
import com.example.blogapp.entity.Post;
import com.example.blogapp.exception.FileStorageException;
import com.example.blogapp.repository.DatabaseFileRepository;
import com.example.blogapp.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class DatabaseFileServiceImpl implements DatabaseFileService{

    @Autowired
    private DatabaseFileRepository dbFileRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public DatabaseFile storeFile(MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try{

            DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());
            return dbFileRepository.save(dbFile);


        }catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public void postUnderUploadedFile(PostDto postDto,String name, DatabaseFile databaseFile) {
        String checkDb = databaseFile.getFileName();
        dbFileRepository.findByFileName(checkDb);

        Post post;
        post = modelMapper.map(postDto,Post.class);

        if(Objects.equals(name, checkDb)){

            databaseFile.setPost(post);

        }
        dbFileRepository.save(databaseFile);
    }
}
