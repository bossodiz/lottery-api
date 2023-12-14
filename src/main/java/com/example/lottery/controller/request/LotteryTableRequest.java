package com.example.lottery.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotteryTableRequest {
    private Integer lotteryTypeId;
    private String number;
    private String playerName;
}
