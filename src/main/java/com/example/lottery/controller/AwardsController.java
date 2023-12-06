package com.example.lottery.controller;

import com.example.lottery.controller.request.AwardsSubmitRequest;
import com.example.lottery.controller.response.Response;
import com.example.lottery.service.AwardsService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("awards")
public class AwardsController {

    @Autowired
    private AwardsService service;
    @GetMapping("/type")
    public Response getAwardsType(){
        return service.getAwardsType();
    }
    @GetMapping("/data")
    public Response getAwards(@PathParam("type") Integer typeId){
        return service.getAwards(typeId);
    }
    @PostMapping("/submit")
    public Response getAwardsSubmit(@RequestBody AwardsSubmitRequest request){
        return service.getAwardsSubmit(request);
    }
}
