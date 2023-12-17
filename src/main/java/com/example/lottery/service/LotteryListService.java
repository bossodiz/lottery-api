package com.example.lottery.service;

import com.example.lottery.controller.response.LotteryTableResponse;
import com.example.lottery.controller.response.Response;
import com.example.lottery.datasource.entity.LotteryNumber;
import com.example.lottery.datasource.entity.Player;
import com.example.lottery.datasource.repository.LotteryNumberRepository;
import com.example.lottery.datasource.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryListService {

    @Autowired
    private SpecificationBuilderService<LotteryNumber> specificationBuilder;

    @Autowired
    private LotteryNumberRepository lotteryNumberRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public Response getAll() {
        List<LotteryNumber> result = lotteryNumberRepository.findAllOrderByNumberAsc();
        LotteryTableResponse response = LotteryTableResponse.builder()
                .data(result)
                .build();
        return Response.builder().code(0).data(response).build();
    }

    public Response getAllPlayers() {
        List<Player> players =  playerRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return Response.builder()
                .code(0)
                .data(players)
                .build();
    }

}
