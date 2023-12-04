package com.example.lottery.service;

import com.example.lottery.controller.response.Response;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public Response<Object> hello() {
        Response<Object> response = Response.builder()
                .data("hello")
                .build();
        return response;
    }
}
