package com.smaato.kafkatrafficstreamer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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

    @PostMapping(value = "/publish")
    public void publishMessage(@RequestParam("message") String message) {
        this.kafkaTemplate.send("trafficCount", message);
    }

}
