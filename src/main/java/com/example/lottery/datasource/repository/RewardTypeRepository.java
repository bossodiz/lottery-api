package com.example.lottery.datasource.repository;

import com.example.lottery.datasource.entity.RewardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardTypeRepository extends JpaRepository<RewardType, Integer> {
}
