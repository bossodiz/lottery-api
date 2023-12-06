package com.example.lottery.utils;

public class Enum {

    public enum SearchOption {
        AND, OR
    }

    public enum SearchOperation {

        LIKE, DOES_NOT_CONTAIN, EQUAL, NOT_EQUAL, BEGINS_WITH,
        DOES_NOT_BEGIN_WITH, ENDS_WITH, DOES_NOT_END_WITH,
        NUL, NOT_NULL, GREATER_THAN, GREATER_THAN_EQUAL, LESS_THAN,
        LESS_THAN_EQUAL, IN, LIKE_LIST_OR, LIKE_LIST_AND
    }
}
