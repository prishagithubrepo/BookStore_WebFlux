package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {
	

    @KafkaListener(topics = "MykafkaTopic1",groupId = "MyKafka-consumer-group-1")
    public void consumeEvents(String message) {
        System.out.println("consumer consume the events {} "+ message);
    }

}
