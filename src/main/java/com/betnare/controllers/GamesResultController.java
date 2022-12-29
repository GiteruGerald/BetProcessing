package com.betnare.controllers;

import com.betnare.dto.GameResult;
import com.betnare.services.GamesResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/games-result")
public record GamesResultController(GamesResultService resultService) {


    @PostMapping
    public ResponseEntity<GameResult> processGameBets(@RequestBody GameResult result) {
        log.info("Game result > {}", result);
        resultService.processGameBets(result);
        return ResponseEntity.ok(result);
    }

}
