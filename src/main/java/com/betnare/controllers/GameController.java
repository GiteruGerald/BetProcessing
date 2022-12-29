package com.betnare.controllers;

import com.betnare.dto.GameDto;
import com.betnare.entities.Game;
import com.betnare.services.GameService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/games")
public record GameController(ObjectMapper objectMapper, GameService gameService) {

    @PostMapping
    public void postGamesData(@RequestBody List<GameDto> games) {
        try {
            log.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(games));
            gameService.bulkSaveGamesData(games);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @GetMapping
    public List<Game> getAllGamesData() {
        return gameService.getAllGamesData();
    }
}
