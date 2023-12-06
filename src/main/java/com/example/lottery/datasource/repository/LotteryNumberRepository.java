package com.example.lottery.datasource.repository;

import com.example.lottery.datasource.entity.LotteryNumber;
import com.example.lottery.service.model.LotteryPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotteryNumberRepository extends JpaRepository<LotteryNumber, Integer> {
    @Query("SELECT new com.example.lottery.service.model.LotteryPlayer(COUNT(L.playerId), P.name) " +
            " FROM LotteryNumber L " +
            " INNER JOIN Player P ON P.id = L.playerId" +
            " GROUP BY L.playerId" +
            " ORDER BY P.name ASC ")
    List<LotteryPlayer> findAllByPlayer();

    Optional<LotteryNumber> findByNumber(String number);


    @Query(value = "select * " +
                    "from lottery_number " +
                    "where player_id is not null " +
                    "ORDER BY RAND() ", nativeQuery = true)
    List<LotteryNumber> findAllByNoPlayer();

    @Query(value = "select DISTINCT l.two_digit_last " +
            "from lottery_number l " +
            "left join reward_history rh on (rh.reward_number = l.two_digit_last and rh.reward_type_id =:reward_type_id ) " +
            "where player_id is not null " +
            "and rh.reward_number is null " +
            "ORDER BY RAND()  "
            , nativeQuery = true)
    List<String> findTwoDigitLastLottery(@Param("reward_type_id") Integer rewardTypeId);

    @Query(value = "select DISTINCT l.three_digit_front " +
            "from lottery_number l " +
            "left join reward_history rh on (rh.reward_number = l.three_digit_front and rh.reward_type_id =:reward_type_id ) " +
            "where player_id is not null " +
            "and rh.reward_number is null " +
            "ORDER BY RAND()  "
            , nativeQuery = true)
    List<String> findThreeDigitFrontLottery(@Param("reward_type_id") Integer rewardTypeId);

    @Query(value = "select DISTINCT l.three_digit_last " +
            "from lottery_number l " +
            "left join reward_history rh on (rh.reward_number = l.three_digit_last and rh.reward_type_id =:reward_type_id ) " +
            "where player_id is not null " +
            "and rh.reward_number is null " +
            "ORDER BY RAND()  "
            , nativeQuery = true)
    List<String> findThreeDigitLastLottery(@Param("reward_type_id") Integer rewardTypeId);

    @Query(value = "select DISTINCT l.number " +
            "from lottery_number l " +
            "left join reward_history rh on (rh.reward_number = l.number and rh.reward_type_id =:reward_type_id ) " +
            "where player_id is not null " +
            "and rh.reward_number is null " +
            "ORDER BY RAND()  "
            , nativeQuery = true)
    List<String> find1stLottery(@Param("reward_type_id") Integer rewardTypeId);
}
