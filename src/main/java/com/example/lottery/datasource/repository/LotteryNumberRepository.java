package com.example.lottery.datasource.repository;

import com.example.lottery.datasource.entity.LotteryNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryNumberRepository extends JpaRepository<LotteryNumber, Integer> {
}
