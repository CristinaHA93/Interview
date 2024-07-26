package com.example.usersapi.exception;

public class ProductInvalidDataException extends RuntimeException{

    public ProductInvalidDataException(String message){
        super(message);
    }

}
