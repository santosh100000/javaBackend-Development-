package com.example.L18kafkademo.config;

import com.example.L18kafkademo.payload.User;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

//@Configuration
//public class KafkaConfig {
//
//
//
//   private final ProducerFactory<String, User> producerFactory;
//
//
//
//    public KafkaConfig(ProducerFactory<String, User> producerFactory) {
//        this.producerFactory = producerFactory;
//    }
//
//    @Bean
//    public KafkaTemplate<String, User> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory);
//    }
//
//
//}


import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    private final ProducerFactory<String, User> producerFactory;

    public KafkaConfig(ProducerFactory<String, User> producerFactory) {
        this.producerFactory = producerFactory;
    }

    @Bean
    public KafkaTemplate<String, User> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public ProducerFactory<String, User> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // Use JsonSerializer for values
        // Other Kafka producer properties

        return new DefaultKafkaProducerFactory<>(configProps);
    }
}
