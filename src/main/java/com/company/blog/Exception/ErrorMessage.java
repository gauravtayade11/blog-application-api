package com.company.blog.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private int statusCode;
    private String message;

    public ErrorMessage(String message){
        super();
        this.message = message;
    }
}
