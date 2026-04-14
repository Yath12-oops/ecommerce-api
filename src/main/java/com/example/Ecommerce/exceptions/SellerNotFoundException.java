package com.example.Ecommerce.exceptions;

public class SellerNotFoundException extends RuntimeException{

    public SellerNotFoundException(String message){
        super(message);
    }
}
