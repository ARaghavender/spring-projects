package com.project.mnc.cc.srvc.kafka;

import com.project.mnc.cc.srvc.kafka.entity.KafkaEntity;
import com.project.mnc.cc.srvc.kafka.repo.KafkaMessageLogRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessageListener {

    public final KafkaMessageLogRepo kafkaMessageLogRepo;


    @KafkaListener(topics = "user-topic", groupId = "user-api-group")
    public void listen(String message,String userid) {
        log.info("Received message from Kafka: {}", message);

        // Create a new KafkaEntity object
        KafkaEntity newMessageEntity = new KafkaEntity();
        newMessageEntity.setMessage(message);  // Set the message
        newMessageEntity.setUserid(Long.valueOf(userid));

        // Save the received message along with timestamp in the database
        kafkaMessageLogRepo.save(newMessageEntity);  // Save the new entity
        log.info("Saved message to DB at timestamp: {}", System.currentTimeMillis());
    }
}

