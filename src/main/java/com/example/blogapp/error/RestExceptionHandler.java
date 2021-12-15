package com.example.blogapp.error;

import com.example.blogapp.exception.PostErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PostErrorException.class)
   public ResponseEntity<ErrorMessage> postNotFoundException(PostErrorException exception){

       ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
   }
}
