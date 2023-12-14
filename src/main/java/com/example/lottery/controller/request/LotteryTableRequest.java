package com.example.lottery.controller.request;

import com.example.lottery.service.model.SearchCriteria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.lottery.utils.Enum;
import java.util.ArrayList;
import java.util.List;

import static com.example.lottery.utils.Constants.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotteryTableRequest {
    private Integer lotteryTypeId;
    private String number;
    private Integer playerId;

    @JsonIgnore
    public List<SearchCriteria> getSearchCriteria() {
        List<SearchCriteria> search = new ArrayList<>();
        if (lotteryTypeId != null) {
            switch (lotteryTypeId) {
                case THREE_DIGIT_FRONT_ID ->  search.add(SearchCriteria.builder()
                        .key(THREE_DIGIT_FRONT)
                        .value(number)
                        .dataOption(Enum.SearchOption.AND)
                        .operation(Enum.SearchOperation.EQUAL)
                        .build());
                case THREE_DIGIT_LAST_ID ->  search.add(SearchCriteria.builder()
                        .key(THREE_DIGIT_LAST)
                        .value(number)
                        .dataOption(Enum.SearchOption.AND)
                        .operation(Enum.SearchOperation.EQUAL)
                        .build());
                case TWO_DIGIT_LAST_ID ->  search.add(SearchCriteria.builder()
                        .key(TWO_DIGIT_LAST)
                        .value(number)
                        .dataOption(Enum.SearchOption.AND)
                        .operation(Enum.SearchOperation.EQUAL)
                        .build());
                case SIX_DIGIT_ID ->  search.add(SearchCriteria.builder()
                        .key(SIX_DIGIT)
                        .value(number)
                        .dataOption(Enum.SearchOption.AND)
                        .operation(Enum.SearchOperation.EQUAL)
                        .build());
            }
        }
        if (playerId != null) {
            search.add(SearchCriteria.builder()
                    .key("player_id")
                    .value(playerId)
                    .dataOption(Enum.SearchOption.AND)
                    .operation(Enum.SearchOperation.EQUAL)
                    .build());
        }
        return search;
    }
}
