package com.example.lottery.datasource.repository;

import com.example.lottery.datasource.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findFirstByName(String name);

    boolean existsPlayerByColor(String color);
}
