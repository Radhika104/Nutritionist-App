package com.stackroute.nutritionist.userservice.exception;


@SuppressWarnings("serial")
public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}