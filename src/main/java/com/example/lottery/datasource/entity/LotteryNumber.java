package com.example.lottery.datasource.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
