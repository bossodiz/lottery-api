package com.example.lottery.controller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddLotteryRequest {
    private String lottery;
    private String playerName;
}
