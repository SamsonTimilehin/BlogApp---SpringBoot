package com.example.blogapp.service;

import com.example.blogapp.entity.DatabaseFile;
import com.example.blogapp.exception.FileStorageException;
import com.example.blogapp.repository.DatabaseFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DatabaseFileServiceImpl implements DatabaseFileService{

    @Autowired
    private DatabaseFileRepository dbFileRepository;


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
}
