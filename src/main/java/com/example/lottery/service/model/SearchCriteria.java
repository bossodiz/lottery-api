package com.example.lottery.service.model;

import com.example.lottery.utils.Enum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
    private String key;
    private Object value;
    private List<?> valueList;
    private Enum.SearchOption dataOption;
    private Enum.SearchOperation operation;
}
