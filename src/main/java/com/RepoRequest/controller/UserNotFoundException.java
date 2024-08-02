package com.RepoRequest.controller;

//added message to exceptions
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
