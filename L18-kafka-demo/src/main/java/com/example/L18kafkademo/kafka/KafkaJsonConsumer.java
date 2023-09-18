package com.example.L18kafkademo.kafka;

import com.example.L18kafkademo.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "jsonTopic", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("Json Message received -> %s", user.toString()));

    }
}
