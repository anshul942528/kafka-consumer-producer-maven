package com.ansh.producer.service;

import com.ansh.producer.config.SenderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private SenderConfig senderConfig;

    public void sendMessage(String msg) {
        kafkaTemplate.send(senderConfig.getTopicName(), msg);
    }
}
