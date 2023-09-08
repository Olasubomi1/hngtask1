package com.hng.hngtaskone.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PayloadResponse implements ServerResponse{
    private String responseCode;
    private String responseMessage;
    private Object responseData;
    public static PayloadResponse getInstance(){
        return new PayloadResponse();
    }
}
