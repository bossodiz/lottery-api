package com.example.lottery.controller.response;

import com.example.lottery.service.model.LotteryPlayer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetChartResponse {
    List<LotteryPlayer> lotteryPlayer;
    Integer lotteryLeft;
}
