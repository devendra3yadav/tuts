package com.example.messaging.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Kafka Consumer Example
 * 
 * Kafka Consumer Concepts:
 * - Consumer: Reads messages from Kafka topics
 * - Consumer Group: Multiple consumers working together to process messages
 * - Offset: Position in the partition from which consumer reads
 * - Auto-commit: Automatically commits offsets after processing
 */
@Component
@Slf4j
public class KafkaConsumer {
    
    /**
     * Kafka Listener
     * 
     * @KafkaListener: Annotation to mark a method as a Kafka message listener
     * - topics: List of topics to listen to
     * - groupId: Consumer group ID (consumers in same group share partitions)
     */
    @KafkaListener(topics = "enterprise-events", groupId = "enterprise-group")
    public void consumeMessage(String message) {
        log.info("Received message from Kafka: {}", message);
        // Process the message
        processMessage(message);
    }
    
    private void processMessage(String message) {
        // Business logic to process the message
        log.debug("Processing Kafka message: {}", message);
    }
}
