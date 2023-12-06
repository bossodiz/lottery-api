package com.example.lottery.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LotteryPlayer {
    private Long total;
    private String playerName;

}
