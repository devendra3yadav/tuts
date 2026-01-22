# 3. Events

This directory contains examples for understanding event-driven architecture.

## Files

- `UserCreatedEvent.java` - Example event class
- `EventPublisher.java` - Component that publishes events
- `EventListeners.java` - Components that listen and react to events
- `AsyncConfig.java` - Configuration for asynchronous event processing
- `UserService.java` - Service demonstrating event publishing

## Key Concepts

- **What is an event**: Immutable facts about past occurrences
- **Event-driven systems**: Systems that communicate through events
- **Publishers and Listeners**: Components that publish and consume events
- **Loose coupling**: Benefits of event-based communication
- **Synchronous vs Asynchronous**: Different ways to process events

## Study Order

1. Read `UserCreatedEvent.java` to understand event structure
2. Read `EventPublisher.java` to see how events are published
3. Read `EventListeners.java` to see how events are consumed
4. Note the difference between synchronous and asynchronous listeners
5. Review `AsyncConfig.java` for async configuration
