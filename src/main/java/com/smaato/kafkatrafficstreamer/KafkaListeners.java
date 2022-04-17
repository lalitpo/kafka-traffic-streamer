package com.smaato.kafkatrafficstreamer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "trafficCount", groupId = "group1")
    void listener(String data) {
        System.out.println("Listener received :" + data);
    }

}
