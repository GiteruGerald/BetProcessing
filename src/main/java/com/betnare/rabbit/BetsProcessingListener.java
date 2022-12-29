package com.betnare.rabbit;


import com.betnare.dto.BetProcessingRequest;
import com.betnare.services.BetProcessingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record BetsProcessingListener(BetProcessingService betProcessingService) {

    @RabbitListener(queues = "#{betProcessingQueue}")
    public void processBet(BetProcessingRequest request) {
        try {
            log.info("{}", request);
            betProcessingService.processGameBet(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
