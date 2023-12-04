package com.example.lottery.datasource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LotteryNumber {
    @Id
    private int id;
    private String number;
    private String threeDigitFront;
    private String threeDigitLast;
    private String twoDigitLast;
    private int playerId;
}
