package com.example.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Event Listeners
 * 
 * Listener: Component that listens for and responds to events
 * 
 * Benefits of Event-Based Communication:
 * - Loose Coupling: Listeners are decoupled from publishers
 * - Multiple Listeners: Multiple components can react to same event
 * - Asynchronous Processing: Events can be processed asynchronously
 * - Easy to Extend: Add new listeners without modifying existing code
 */
@Component
@Slf4j
public class EventListeners {
    
    /**
     * Synchronous Event Listener
     * Executes in the same thread as the publisher
     */
    @EventListener
    public void handleUserCreatedEvent(UserCreatedEvent event) {
        log.info("Synchronous listener - User created: {}", event.getUsername());
        // Send welcome email
        sendWelcomeEmail(event);
    }
    
    /**
     * Asynchronous Event Listener
     * Executes in a separate thread, non-blocking
     */
    @EventListener
    @Async
    public void handleUserCreatedEventAsync(UserCreatedEvent event) {
        log.info("Asynchronous listener - User created: {}", event.getUsername());
        // Update analytics
        updateAnalytics(event);
    }
    
    /**
     * Multiple listeners can handle the same event
     */
    @EventListener
    @Async
    public void sendNotification(UserCreatedEvent event) {
        log.info("Sending notification for new user: {}", event.getUsername());
        // Notification logic
    }
    
    private void sendWelcomeEmail(UserCreatedEvent event) {
        log.debug("Sending welcome email to: {}", event.getEmail());
        // Email sending logic
    }
    
    private void updateAnalytics(UserCreatedEvent event) {
        log.debug("Updating analytics for user: {}", event.getUserId());
        // Analytics update logic
    }
}
