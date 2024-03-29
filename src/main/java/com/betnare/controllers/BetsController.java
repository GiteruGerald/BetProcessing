package com.betnare.controllers;

import com.betnare.entities.Bet;
import com.betnare.services.BetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/bets")
public record BetsController(BetsService betsService) {

    @PostMapping
    public ResponseEntity<Bet> createNewBet(@RequestBody Bet bet) {
        Bet saved = betsService.placeBet(bet);
        return ResponseEntity.ok(saved);
    }
}
