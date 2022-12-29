package com.betnare.rabbit;


import com.betnare.dto.BetProcessingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record BetsProcessingListener() {

    @RabbitListener(queues = "#{betProcessingQueue}")
    public void processBet(BetProcessingRequest request) {
        try {

            log.info("{}", request);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
