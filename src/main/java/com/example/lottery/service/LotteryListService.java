package com.example.lottery.service;

import com.example.lottery.controller.request.LotteryTableRequest;
import com.example.lottery.controller.response.LotteryTableResponse;
import com.example.lottery.controller.response.Response;
import com.example.lottery.datasource.entity.LotteryNumber;
import com.example.lottery.datasource.repository.LotteryNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryListService {

    @Autowired
    private SpecificationBuilderService<LotteryNumber> specificationBuilder;

    @Autowired
    private LotteryNumberRepository lotteryNumberRepository;

    public Response getAll(LotteryTableRequest request) {
        List<LotteryNumber> result = lotteryNumberRepository.findAll();
        LotteryTableResponse response = LotteryTableResponse.builder()
                .data(result)
                .build();
        return Response.builder().code(0).data(response).build();
    }
}
