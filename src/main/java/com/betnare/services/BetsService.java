package com.betnare.services;

import com.betnare.entities.Bet;
import com.betnare.repositories.BetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public record BetsService(BetRepository betRepository) {

    public Bet placeBet(Bet bet) {
        Objects.requireNonNull(bet.getGameId(), "Game id is required to place a bet");
        return betRepository.save(bet);
    }
}
