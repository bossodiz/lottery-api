package com.example.lottery.service;

import com.example.lottery.controller.request.AddLotteryRequest;
import com.example.lottery.controller.request.AddPlayerRequest;
import com.example.lottery.controller.response.GetChartResponse;
import com.example.lottery.controller.response.Response;
import com.example.lottery.datasource.entity.LotteryNumber;
import com.example.lottery.datasource.entity.Player;
import com.example.lottery.datasource.repository.LotteryNumberRepository;
import com.example.lottery.datasource.repository.PlayerRepository;
import com.example.lottery.service.model.LotteryPlayer;
import com.example.lottery.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private LotteryNumberRepository lotteryNumberRepository;
    public Response getChart() {
        List<LotteryPlayer> lotteryPlayerList = lotteryNumberRepository.findAllByPlayer();
        List<LotteryNumber> lotteryLeft = lotteryNumberRepository.findAllByNoPlayer();
        GetChartResponse getChartResponse = GetChartResponse.builder()
                .lotteryPlayer(lotteryPlayerList)
                .lotteryLeft(lotteryLeft.size())
                .build();
        return Response.builder()
                .code(0)
                .data(getChartResponse)
                .build();
    }

    public Response getPlayers() {
        List<Player> players =  playerRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return Response.builder()
                .code(0)
                .data(players)
                .build();
    }

    public Response addPlayer(AddPlayerRequest request) {
        Player player = new Player();
        player.setName(request.getName());
        player = playerRepository.save(player);
        return Response.builder()
                .code(0)
                .data(player)
                .build();
    }

    public Response addLottery(AddLotteryRequest request) {
        LotteryNumber lotteryNumber = lotteryNumberRepository.findByNumber(request.getLottery()).orElse(new LotteryNumber());
        lotteryNumber.setNumber(request.getLottery());
        lotteryNumber.setTwoDigitLast(StringUtils.getLast(request.getLottery(), 2));
        lotteryNumber.setThreeDigitFront(StringUtils.getFront(request.getLottery(), 3));
        lotteryNumber.setThreeDigitLast(StringUtils.getLast(request.getLottery(), 3));
        lotteryNumber.setPlayerId(request.getPlayerId());
        lotteryNumberRepository.save(lotteryNumber);
        return Response.builder()
                .code(0)
                .data(lotteryNumber)
                .build();
    }
}
