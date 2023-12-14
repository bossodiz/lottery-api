package com.example.lottery.controller.response;

import com.example.lottery.datasource.entity.LotteryNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotteryTableResponse {
    List<LotteryNumber> data;
}
