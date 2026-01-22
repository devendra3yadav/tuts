package com.example.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Event Publisher
 * 
 * Publisher: Component that publishes events to notify other parts of the system
 * 
 * Benefits:
 * - Loose coupling: Publisher doesn't need to know about listeners
 * - Extensibility: Easy to add new listeners without changing publisher
 * - Asynchronous: Events can be processed asynchronously
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class EventPublisher {
    
    private final ApplicationEventPublisher eventPublisher;
    
    /**
     * Publish a user created event
     * All registered listeners for UserCreatedEvent will be notified
     */
    public void publishUserCreatedEvent(Long userId, String username, String email) {
        log.info("Publishing UserCreatedEvent for user: {}", username);
        UserCreatedEvent event = new UserCreatedEvent(
            userId, 
            username, 
            email, 
            java.time.LocalDateTime.now()
        );
        eventPublisher.publishEvent(event);
    }
}
