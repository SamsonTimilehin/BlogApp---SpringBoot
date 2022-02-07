package com.example.blogapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class BlogAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlogAppApplication.class, args);
    }

}
