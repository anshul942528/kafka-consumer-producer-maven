package com.ansh.consumer.service;

import com.ansh.consumer.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    @KafkaListener(topics = "topicName", groupId = "group-id", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String message) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            User user = mapper.readValue(message, User.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info("Message received is : " + message);
    }
}
