package com.example.blogapp.exception;

public class PostErrorException extends Exception{
    public PostErrorException() {
    }

    public PostErrorException(String message) {
        super(message);
    }

    public PostErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostErrorException(Throwable cause) {
        super(cause);
    }

    public PostErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
