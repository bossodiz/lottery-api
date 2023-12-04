package com.example.lottery.datasource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RewardType {
    @Id
    private int id;
    private String rewardTypeName;
    private String rewardTypeDescription;
}