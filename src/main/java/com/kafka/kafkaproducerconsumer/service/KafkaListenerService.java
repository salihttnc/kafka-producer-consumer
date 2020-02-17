package com.kafka.kafkaproducerconsumer.service;


import com.kafka.kafkaproducerconsumer.dto.KMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j  // loglama icin kullanılır
@Service
public class KafkaListenerService {

    @KafkaListener(
            topics = "${stutuncu.kafka.topic}",
            groupId = "${stutuncu.kafka.group.id}"
    )
    public void listen(@Payload KMessage message) {
        log.info("Message received.. MessageID : {} Message: {} Date : {}",
                message.getId(),
                message.getMessage(),
                message.getMessageDate());
    }
}