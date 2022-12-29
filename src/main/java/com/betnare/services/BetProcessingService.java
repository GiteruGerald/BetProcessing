package com.betnare.services;

import com.betnare.dto.BetProcessingRequest;
import com.betnare.dto.GameResult;
import com.betnare.entities.Bet;
import com.betnare.enums.BetOdds;
import com.betnare.exceptions.ResourceNotFoundException;
import com.betnare.repositories.BetRepository;
import com.betnare.repositories.GameRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class BetProcessingService {
    private final GameRepository gameRepository;
    private final BetRepository betRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    public void processGameBet(BetProcessingRequest request) {
        var gameId = request.getGameId();

        Objects.requireNonNull(gameId, "Game Id is required for processing bet");
//
//        var game = gameRepository.findByGameId(gameId)
//                .orElseThrow(() -> new ResourceNotFoundException(String.format("Game with id %s was not found", gameId)));
//

        GameResult gameResult = request.getResult();
        List<BetOdds> winningOdds = getWinningOdds(gameResult);

        //Check for all bets against the gameId that have 1+ winning odds in them.
        List<Bet> winningBets = betRepository.findAllByGameIdAndOddPicksIn(gameId, winningOdds);

        try {
            log.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(winningBets));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //We can do anything with this
        // Calculate won amount
        // Disburse amount won
        // Notify users of bets won
    }

    private static List<BetOdds> getWinningOdds(GameResult gameResult) {
        List<BetOdds> winningOdds = new ArrayList<>();

        if (gameResult.getHomeTeamScore() > gameResult.getAwayTeamScore())
            winningOdds.add(BetOdds.HOME_ODD);

        if (gameResult.getAwayTeamScore() > gameResult.getHomeTeamScore())
            winningOdds.add(BetOdds.AWAY_ODD);

        if (gameResult.getAwayTeamScore().equals(gameResult.getHomeTeamScore()))
            winningOdds.add(BetOdds.NEUTRAL_ODD);

        if (gameResult.getHomeTeamScore() > 0 && gameResult.getAwayTeamScore() > 0)
            winningOdds.add(BetOdds.BTS_YES);
        else
            winningOdds.add(BetOdds.BTS_NO);

        if (gameResult.getAwayTeamScore() + gameResult.getAwayTeamScore() > 2.5)
            winningOdds.add(BetOdds.OVER_2_5);
        else
            winningOdds.add(BetOdds.UNDER_2_5);

        return winningOdds;
    }

}
