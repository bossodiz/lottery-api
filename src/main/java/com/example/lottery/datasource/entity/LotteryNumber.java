package com.example.lottery.datasource.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LotteryNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private String threeDigitFront;
    private String threeDigitLast;
    private String twoDigitLast;
    private Integer playerId;
    @Transient
    private String playerName;
}
