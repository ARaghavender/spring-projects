package com.project.kafka;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message, Long userid) {
        logger.info("Sending message to Kafka: {}", message);
        kafkaTemplate.send("user-topic", message, String.valueOf(userid)); // topic name
        System.out.println("RECEIVED: " + message);

    }
}
