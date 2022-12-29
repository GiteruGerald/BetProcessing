package com.betnare.services;

import com.betnare.dto.BetProcessingRequest;
import com.betnare.dto.GameResult;
import com.betnare.enums.RabbitQueues;
import com.betnare.repositories.GameRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public record GamesResultService(GameRepository gameRepository, RabbitTemplate template) {

    public void processGameBets(GameResult result) {
        var matchBets = gameRepository.findAllByMatchId(result.getMatchId());

        //Add all to the queue for processing
        matchBets.forEach(game ->
                template.convertAndSend(RabbitQueues.BET_PROCESSING_QUEUE.name(), new BetProcessingRequest(game.getGameId(), result)));
    }
}
