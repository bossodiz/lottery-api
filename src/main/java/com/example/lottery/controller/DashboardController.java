package com.example.lottery.controller;

import com.example.lottery.controller.request.AddLotteryRequest;
import com.example.lottery.controller.request.AddPlayerRequest;
import com.example.lottery.controller.response.Response;
import com.example.lottery.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping("get-chart")
    public Response getChart(){
        return service.getChart();
    }

    @GetMapping("get-players")
    public Response getPlayers(){
        return service.getPlayers();
    }

    @PostMapping("add-player")
    public Response addPlayer(@RequestBody AddPlayerRequest request) {
        return service.addPlayer(request);
    }

    @PostMapping("add-lottery")
    public Response addLottery(@RequestBody AddLotteryRequest request) {
        return service.addLottery(request);
    }
}
