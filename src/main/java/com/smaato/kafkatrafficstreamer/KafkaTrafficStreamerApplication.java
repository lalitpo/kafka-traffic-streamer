package com.smaato.kafkatrafficstreamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;

@EnableDiscoveryClient
@EnableKafka
@SpringBootApplication
public class KafkaTrafficStreamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaTrafficStreamerApplication.class, args);
	}

}
