package com.example.L18kafkademo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducers {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducers.class);

//    In order to send messages to topic we will use, Spring provided Kafka Template
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducers(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("message sent", message));
        kafkaTemplate.send("firstTopic", message);
    }
}
