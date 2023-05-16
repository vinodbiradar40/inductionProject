package com.example.InductionProject.ExceptionHandler;



public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException(String message) {
        super(message);
    }
}
