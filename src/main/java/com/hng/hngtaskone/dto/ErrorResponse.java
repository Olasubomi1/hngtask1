package com.hng.hngtaskone.dto;

public class ErrorResponse implements ServerResponse{
    private String responseCode;
    private String responseMessage;
    public static ErrorResponse getInstance(){
        return new ErrorResponse();
    }
}
