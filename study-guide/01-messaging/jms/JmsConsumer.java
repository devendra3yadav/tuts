package com.example.messaging.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * JMS Consumer Example
 * 
 * Consumer: Component that receives and processes messages from a queue or topic
 * 
 * Key Concepts:
 * - @JmsListener: Annotation to mark a method as a message listener
 * - Queue Consumer: Receives messages from a queue (Point-to-Point)
 * - Topic Consumer: Receives messages from a topic (Publish-Subscribe)
 */
@Component
@Slf4j
public class JmsConsumer {
    
    /**
     * Queue Listener - Point-to-Point
     * Only one consumer instance will receive each message
     */
    @JmsListener(destination = "enterprise.queue")
    public void receiveFromQueue(String message) {
        log.info("Received message from queue: {}", message);
        // Process the message
        processMessage(message);
    }
    
    /**
     * Topic Listener - Publish-Subscribe
     * All subscribed consumers will receive the same message
     */
    @JmsListener(destination = "enterprise.topic")
    public void receiveFromTopic(String message) {
        log.info("Received message from topic: {}", message);
        // Process the message
        processMessage(message);
    }
    
    private void processMessage(String message) {
        // Business logic to process the message
        log.debug("Processing message: {}", message);
    }
}
