package com.betnare.configs;

import com.betnare.enums.RabbitQueues;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    @Bean
    public MessageConverter messageConverter(ObjectMapper mapper) {
        return new Jackson2JsonMessageConverter(mapper);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Config.EXCHANGE.getName());
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(Config.ROUTING_KEY.getName());
    }

    @Bean
    public Queue betProcessingQueue() {
        return new Queue(RabbitQueues.BET_PROCESSING_QUEUE.name());
    }

    @Getter
    @AllArgsConstructor
    public enum Config {
        EXCHANGE("exchange"),

        ROUTING_KEY("#");

        private final String name;

    }
}
