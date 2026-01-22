package com.example.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Event Example
 * 
 * What is an Event:
 * - An event represents something that has happened in the system
 * - Events are immutable facts about past occurrences
 * 
 * Event-Driven Architecture:
 * - Systems communicate through events
 * - Loose coupling: Publishers don't know about subscribers
 * - Scalable: Easy to add new event listeners
 * - Reactive: System responds to events as they occur
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatedEvent {
    private Long userId;
    private String username;
    private String email;
    private LocalDateTime createdAt;
}
