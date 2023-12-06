package com.example.lottery.controller;

import com.example.lottery.controller.request.LotteryTableRequest;
import com.example.lottery.controller.response.Response;
import com.example.lottery.service.LotteryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lottery")
public class LotteryListController {

    @Autowired
    private LotteryListService lotteryListService;

    @PostMapping("/table")
    public Response getDataLottery(@RequestBody LotteryTableRequest lotteryTableRequest){
        return lotteryListService.getAll(lotteryTableRequest);
    }

}
