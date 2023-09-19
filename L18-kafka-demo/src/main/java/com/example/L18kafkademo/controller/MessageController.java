package com.example.L18kafkademo.controller;


import com.example.L18kafkademo.kafka.KafkaProducers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducers kafkaProducers;

    public MessageController(KafkaProducers kafkaProducers) {
        this.kafkaProducers = kafkaProducers;
    }

    //http:localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping ("/publish")
    public ResponseEntity<String> publish(@RequestParam String message){
       kafkaProducers.sendMessage(message);
       return ResponseEntity.ok("Message sent to topic");

    }
}
