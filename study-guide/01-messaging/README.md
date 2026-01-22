# 1. Messaging (Asynchronous Communication)

This directory contains examples and code for understanding messaging in enterprise applications.

## Files

### JMS (Java Message Service)
- `jms/JmsProducer.java` - Producer that sends messages to queues and topics
- `jms/JmsConsumer.java` - Consumer that receives messages from queues and topics

### Kafka
- `kafka/KafkaProducer.java` - Kafka producer example
- `kafka/KafkaConsumer.java` - Kafka consumer example

### Controller
- `MessagingController.java` - REST endpoints to test messaging functionality

## Key Concepts

- **Synchronous vs Asynchronous**: Understanding blocking vs non-blocking communication
- **Producer/Consumer**: Components that send and receive messages
- **Queue vs Topic**: Point-to-Point vs Publish-Subscribe patterns
- **JMS vs Kafka**: Differences between traditional messaging and distributed streaming

## Study Order

1. Read `jms/JmsProducer.java` and `jms/JmsConsumer.java` to understand JMS
2. Read `kafka/KafkaProducer.java` and `kafka/KafkaConsumer.java` to understand Kafka
3. Compare the two approaches
4. Test using `MessagingController.java` endpoints
