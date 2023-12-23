package com.example.lottery.service;

import com.example.lottery.controller.request.AddLotteryRequest;
import com.example.lottery.controller.request.AddPlayerRequest;
import com.example.lottery.controller.request.DeletePlayerRequest;
import com.example.lottery.controller.response.GetChartResponse;
import com.example.lottery.controller.response.Response;
import com.example.lottery.datasource.entity.LotteryNumber;
import com.example.lottery.datasource.entity.Player;
import com.example.lottery.datasource.repository.LotteryNumberRepository;
import com.example.lottery.datasource.repository.PlayerRepository;
import com.example.lottery.error.DuplicateException;
import com.example.lottery.service.model.LotteryPlayer;
import com.example.lottery.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private LotteryNumberRepository lotteryNumberRepository;
    public Response getChart() {
        List<LotteryPlayer> lotteryPlayerList = lotteryNumberRepository.findAllByPlayer();
        List<LotteryNumber> lotteryLeft = lotteryNumberRepository.findAllByNoPlayer();
        GetChartResponse getChartResponse = GetChartResponse.builder()
                .lotteryPlayer(lotteryPlayerList)
                .lotteryLeft(lotteryLeft.size())
                .build();
        return Response.builder()
                .code(0)
                .data(getChartResponse)
                .build();
    }

    public Response getPlayers() {
        List<Player> players =  playerRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return Response.builder()
                .code(0)
                .data(players)
                .build();
    }

    public Response addPlayer(AddPlayerRequest request) throws DuplicateException {
        Player player = new Player();
        player.setName(request.getName().trim());
        Player checkPlayer = playerRepository.findFirstByName(player.getName()).orElse(new Player());
        if(checkPlayer.getName() != null ) {
            throw new DuplicateException("ชื่อนี้มีคนลงทะเบียนไปแล้ว");
        }

        String colorStr = "rgb(%s, %s, %s)";
        do {
            Color color = new Color((int) (Math.random() * 0x1000000));
            colorStr = String.format(colorStr, color.getRed(), color.getGreen(), color.getBlue());
        } while (playerRepository.existsPlayerByColor(colorStr));
        player.setColor(colorStr);
        player.setIsPrizeDraw(false);
        player = playerRepository.save(player);
        return Response.builder()
                .code(0)
                .data(player)
                .build();
    }

    public Response addLottery(AddLotteryRequest request) throws DuplicateException {
        String number = request.getLottery().trim();
        LotteryNumber lotteryNumber = lotteryNumberRepository.findByNumber(number).orElse(new LotteryNumber());
        if (lotteryNumber.getPlayerId() != null) {
            throw new DuplicateException("มีคนลงทะเบียนเลขนี้ไปแล้ว");
        }
        Optional<Player> optionalPlayer = playerRepository.findFirstByName(request.getPlayerName());
        if (!optionalPlayer.isPresent()) {
            throw new DuplicateException("ไม่มีชื่อนี้ในระบบ");
        }
        lotteryNumber.setNumber(number);
        lotteryNumber.setTwoDigitLast(StringUtils.getLast(number, 2));
        lotteryNumber.setThreeDigitFront(StringUtils.getFront(number, 3));
        lotteryNumber.setThreeDigitLast(StringUtils.getLast(number, 3));
        lotteryNumber.setPlayerId(optionalPlayer.get().getId());
        lotteryNumberRepository.save(lotteryNumber);
        return Response.builder()
                .code(0)
                .data(lotteryNumber)
                .build();
    }

    public Response deletePlayer(DeletePlayerRequest request) throws DuplicateException {
        Player player = playerRepository.findFirstByName(request.getName()).orElse(new Player());
        player.setName(request.getName().trim());
        if(player.getName() == null ) {
            throw new DuplicateException("ไม่สามารถลบได้เนื่องจากไม่มีชื่อนี้ในระบบ");
        }
        playerRepository.delete(player);
        return Response.builder()
                .code(0)
                .data(player)
                .build();
    }
}
