package com.example.messaging;

import com.example.messaging.jms.JmsProducer;
import com.example.messaging.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller to demonstrate messaging
 */
@RestController
@RequestMapping("/api/messaging")
@RequiredArgsConstructor
public class MessagingController {
    
    private final JmsProducer jmsProducer;
    private final KafkaProducer kafkaProducer;
    
    @PostMapping("/jms/queue")
    public ResponseEntity<String> sendJmsQueueMessage(@RequestBody String message) {
        jmsProducer.sendToQueue(message);
        return ResponseEntity.ok("Message sent to JMS queue");
    }
    
    @PostMapping("/jms/topic")
    public ResponseEntity<String> sendJmsTopicMessage(@RequestBody String message) {
        jmsProducer.sendToTopic(message);
        return ResponseEntity.ok("Message published to JMS topic");
    }
    
    @PostMapping("/kafka")
    public ResponseEntity<String> sendKafkaMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic");
    }
}
