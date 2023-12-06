package com.example.lottery.service;

import com.example.lottery.controller.response.Response;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public Response hello() {
        String resp = "hello";
        return Response.builder()
                .data(resp)
                .build();
    }
}
