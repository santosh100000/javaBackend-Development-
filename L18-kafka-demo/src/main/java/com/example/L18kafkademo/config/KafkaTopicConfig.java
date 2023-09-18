package com.example.L18kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic newTopicDemo(){
        return TopicBuilder.name("firstTopic").build();

    }

    @Bean
    public NewTopic newTopicJsonDemo(){
        return TopicBuilder.name("jsonTopic").build();

    }


}
