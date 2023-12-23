package com.example.lottery.service;

import com.example.lottery.controller.request.AwardsSubmitRequest;
import com.example.lottery.controller.response.AwardsResponse;
import com.example.lottery.controller.response.Response;
import com.example.lottery.datasource.entity.RewardHistory;
import com.example.lottery.datasource.entity.RewardType;
import com.example.lottery.datasource.repository.LotteryNumberRepository;
import com.example.lottery.datasource.repository.RewardHistoryRepository;
import com.example.lottery.datasource.repository.RewardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.lottery.utils.Constants.*;

@Service
public class AwardsService {

    @Autowired
    private RewardTypeRepository rewardTypeRepository;

    @Autowired
    private LotteryNumberRepository lotteryNumberRepository;

    @Autowired
    private RewardHistoryRepository rewardHistoryRepository;

    public Response getAwardsType() {
        List<RewardType> list = rewardTypeRepository.findAll();
        return Response.builder()
                .code(0)
                .data(list)
                .build();
    }

    public Response getAwards(Integer typeId) {
        List<String> list = new ArrayList<>();
        switch (typeId) {
            case THREE_DIGIT_FRONT_ID -> list =
                    lotteryNumberRepository.findThreeDigitFrontLottery(THREE_DIGIT_FRONT_ID);
            case THREE_DIGIT_LAST_ID ->
                list = lotteryNumberRepository.findThreeDigitLastLottery(THREE_DIGIT_LAST_ID);
            case TWO_DIGIT_LAST_ID ->
                list = lotteryNumberRepository.findTwoDigitLastLottery(TWO_DIGIT_LAST_ID);
            case SIX_DIGIT_ID ->
                list = lotteryNumberRepository.find1stLottery(SIX_DIGIT_ID);
            case PLAYERS_ID->
                list = lotteryNumberRepository.findByPlayer();
        }
        AwardsResponse awardsResponse = AwardsResponse.builder()
                .lottery(list)
                .build();
        return Response.builder()
                .code(0)
                .data(awardsResponse)
                .build();
    }

    public Response getAwardsSubmit(AwardsSubmitRequest request) {
        RewardHistory rewardHistory = new RewardHistory();
        rewardHistory.setReward(request.getNumber().trim());
        rewardHistory.setRewardTypeId(request.getLotteryTypeId());
        rewardHistory = rewardHistoryRepository.save(rewardHistory);
        return Response.builder()
                .code(0)
                .data(rewardHistory)
                .build();
    }
}
