package com.betnare.services;

import com.betnare.dto.GameDto;
import com.betnare.entities.Game;
import com.betnare.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record GameService(GameRepository gameRepository) {
    public void bulkSaveGamesData(List<GameDto> games) {
        games.stream().map(Game::new).forEach(gameRepository::save);
    }

    public List<Game> getAllGamesData() {
        return gameRepository.findAll();
    }
}
