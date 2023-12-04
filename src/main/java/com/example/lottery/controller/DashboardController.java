package com.example.lottery.controller;

import com.example.lottery.controller.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dashboard")
public class DashboardController {

    @GetMapping("get-chart")
    public Response<Object> getChart(){
        return null;
    }
}
