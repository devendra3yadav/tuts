package com.example.messaging.jms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * JMS Producer Example
 * 
 * Producer: Component that sends messages to a queue or topic
 * 
 * Key Concepts:
 * - Producer sends messages to destinations (Queue or Topic)
 * - Queue: Point-to-Point messaging (one consumer per message)
 * - Topic: Publish-Subscribe messaging (multiple consumers can receive same message)
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class JmsProducer {
    
    private final JmsTemplate jmsTemplate;
    
    /**
     * Send message to a Queue (Point-to-Point)
     * Only one consumer will receive this message
     */
    public void sendToQueue(String message) {
        log.info("Sending message to queue: {}", message);
        jmsTemplate.convertAndSend("enterprise.queue", message);
    }
    
    /**
     * Send message to a Topic (Publish-Subscribe)
     * All subscribed consumers will receive this message
     */
    public void sendToTopic(String message) {
        log.info("Publishing message to topic: {}", message);
        jmsTemplate.convertAndSend("enterprise.topic", message);
    }
}
