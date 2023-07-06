package com.company.blog.Exception;


public class ResourceNotFound extends RuntimeException{

    private String message;

    public ResourceNotFound(){}

    public ResourceNotFound(String message){
        super(message);
        this.message = message;
    }
}
