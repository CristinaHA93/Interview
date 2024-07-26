package com.example.usersapi.exception;

public class NoFoundException extends RuntimeException{

    public NoFoundException(Integer id){
        super(String.format("Result with id %d not found", id));
    }

}
