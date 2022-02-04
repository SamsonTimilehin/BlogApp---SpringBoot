package com.example.blogapp.repository;

import com.example.blogapp.entity.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {

    void findByFileName(String filename);
}
