package com.example.lottery.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private int code;
    private String errorMessage;
    private Object data;

}
