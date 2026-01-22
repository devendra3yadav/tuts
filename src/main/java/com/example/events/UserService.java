package com.example.events;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service demonstrating event publishing
 */
@Service
@RequiredArgsConstructor
public class EventUserService {
    
    private final EventPublisher eventPublisher;
    
    public void createUser(String username, String email) {
        // Create user logic
        Long userId = 1L; // Simulated user ID
        
        // Publish event after user creation
        eventPublisher.publishUserCreatedEvent(userId, username, email);
    }
}
