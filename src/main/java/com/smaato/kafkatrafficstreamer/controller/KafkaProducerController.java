package com.smaato.kafkatrafficstreamer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/messageStream")
public class KafkaProducerController {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping(value = "/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("count") String count) {
        try {
            this.kafkaTemplate.send("trafficCount", count);

            
        } catch (Exception e) {
            return new ResponseEntity<String>("Exception in Kafka", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfull in Kafka", HttpStatus.OK);

    }

}
