package com.example.lottery.controller;

import com.example.lottery.controller.response.Response;
import com.example.lottery.error.DataNotFoundException;
import com.example.lottery.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotteryController {

    @Autowired
    private HelloService service;

    @GetMapping("hello")
    public Response<Object> hello() throws DataNotFoundException {
        return service.hello();
    }
}
