package com.projects.socialmediabackend.rest.exception;

public class TokenExpiredException extends RuntimeException{
    public TokenExpiredException(String message) {
        super(message);
    }
}
