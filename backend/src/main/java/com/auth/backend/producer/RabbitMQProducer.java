package com.auth.backend.producer;

import com.auth.backend.config.RabbitMQConfig;
import com.auth.backend.dto.auth.EmailPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQProducer {
    private final RabbitTemplate template;

    public void sendMessageWithRabbitMQ(EmailPayload payload){
        template
                .convertAndSend(
                        RabbitMQConfig.QUEUE_EXCHANGE_NAME,
                        RabbitMQConfig.QUEUE_ROUTING_KEY,
                        payload
                );
    }
}
