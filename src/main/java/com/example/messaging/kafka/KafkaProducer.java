package com.example.messaging.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Kafka Producer Example
 * 
 * Kafka Concepts:
 * - Producer: Sends messages to Kafka topics
 * - Topic: Category or feed name to which messages are published
 * - Partition: Topics are divided into partitions for scalability
 * - Broker: Kafka server that stores and serves messages
 * 
 * Kafka vs JMS:
 * - Kafka is distributed, scalable, and designed for high throughput
 * - Kafka retains messages for a configurable period (log-based)
 * - Kafka supports replaying messages
 * - JMS is more traditional, simpler for basic messaging needs
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    /**
     * Send message to Kafka topic
     * 
     * @param message The message to send
     */
    public void sendMessage(String message) {
        log.info("Sending message to Kafka topic: {}", message);
        kafkaTemplate.send("enterprise-events", message);
    }
    
    /**
     * Send message with a specific key
     * Messages with the same key go to the same partition
     * 
     * @param key Message key (for partitioning)
     * @param message The message to send
     */
    public void sendMessageWithKey(String key, String message) {
        log.info("Sending message with key {} to Kafka topic: {}", key, message);
        kafkaTemplate.send("enterprise-events", key, message);
    }
}
