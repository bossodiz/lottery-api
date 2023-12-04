package com.example.lottery.datasource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RewardHistory {
    @Id
    private int id;
    private String rewardNumber;
    private int rewardTypeId;
}
