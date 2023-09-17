package com.example.L18kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaDemoController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/push")
    public ResponseEntity<String> pushMsg(@RequestParam String msg){
         kafkaTemplate.send("topic01", msg);
         return ResponseEntity.ok(msg);
    }


}
