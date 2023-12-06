package com.example.lottery.service;

import com.example.lottery.controller.request.LotteryTableRequest;
import com.example.lottery.controller.response.LotteryTableResponse;
import com.example.lottery.controller.response.Response;
import com.example.lottery.datasource.entity.LotteryNumber;
import com.example.lottery.datasource.repository.LotteryNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class LotteryListService {

    @Autowired
    private SpecificationBuilderService<LotteryNumber> specificationBuilder;

    @Autowired
    private LotteryNumberRepository lotteryNumberRepository;

    public Response getAll(LotteryTableRequest request) {
        Pageable pageable;
        if (request.getSort() != null && request.getDirection() != null) {
            pageable = PageRequest.of(request.getPage(), request.getPageSize(),
                    Sort.by(Sort.Direction.fromString(request.getDirection()), request.getSort()));
        } else {
            pageable = PageRequest.of(request.getPage(), request.getPageSize());
        }
        Specification<LotteryNumber> specification =
                specificationBuilder.buildSpecification(request.getSearchCriteria());
        Page<LotteryNumber> result = lotteryNumberRepository.findAll(specification, pageable);
        LotteryTableResponse response = LotteryTableResponse.builder()
                .data(result.toList())
                .page(request.getPage())
                .pageSize(request.getPageSize())
                .sort(request.getSort())
                .direction(request.getDirection())
                .totalRecord((int) result.getTotalElements())
                .totalPage(result.getTotalPages())
                .build();
        return Response.builder().code(0).data(response).build();
    }
}