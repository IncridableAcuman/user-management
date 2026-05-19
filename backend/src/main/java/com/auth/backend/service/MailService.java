package com.auth.backend.service;

import com.auth.backend.producer.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final RabbitMQProducer rabbitMQProducer;
}
