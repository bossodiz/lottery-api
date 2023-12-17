package com.example.lottery.controller;

import com.example.lottery.controller.response.Response;
import com.example.lottery.service.LotteryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lottery")
public class LotteryListController {

    @Autowired
    private LotteryListService lotteryListService;

    @GetMapping("/search")
    public Response getDataLottery(){
        return lotteryListService.getAll();
    }
    @GetMapping("/get-players")
    public Response getPlayers(){
        return lotteryListService.getAllPlayers();
    }

}
