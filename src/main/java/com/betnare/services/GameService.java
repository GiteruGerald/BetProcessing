package com.betnare.services;

import com.betnare.dto.BetProcessingRequest;
import com.betnare.dto.GameDto;
import com.betnare.dto.GameResult;
import com.betnare.entities.Game;
import com.betnare.enums.RabbitQueues;
import com.betnare.repositories.GameRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record GameService(GameRepository gameRepository, RabbitTemplate template) {
    public void bulkSaveGamesData(List<GameDto> games) {
        games.stream().map(Game::new).forEach(gameRepository::save);
    }

    public List<Game> getAllGamesData() { return gameRepository.findAll(); }
}
