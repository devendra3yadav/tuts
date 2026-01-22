# Enterprise Spring Boot Study Guide

This directory contains all study materials organized by topic for easy navigation.

## Directory Structure

```
study-guide/
├── 01-messaging/          # Messaging (JMS & Kafka)
├── 02-scheduling/         # Task Scheduling
├── 03-events/             # Event-Driven Architecture
├── 04-configuration/      # Spring Boot Configuration
├── 05-logging/            # Logging
├── 06-testing/            # Testing (Unit, Repository, RestAssured)
├── common/                # Common files used across examples
├── README.md              # Main project README
└── pom.xml                # Maven project file
```

## Study Path

Follow this order for comprehensive learning:

### 1. Start with Configuration (04-configuration)
Understanding configuration is fundamental to everything else.

### 2. Learn Logging (05-logging)
Essential for debugging and understanding other examples.

### 3. Study Messaging (01-messaging)
Learn asynchronous communication patterns.

### 4. Understand Scheduling (02-scheduling)
Learn how to automate tasks.

### 5. Explore Events (03-events)
Understand event-driven architecture.

### 6. Master Testing (06-testing)
Learn to test your applications properly.

## Quick Reference

- **Main README**: See `README.md` for comprehensive documentation
- **Topic READMEs**: Each directory has its own README with specific information
- **Source Code**: All Java files are in their respective topic directories
- **Configuration**: Configuration files are in `04-configuration/`

## Running the Project

The complete Spring Boot project is in the parent directory (`../src/`). 
This `study-guide/` directory contains organized copies for easy study.

To run the full project:
```bash
cd ..
mvn spring-boot:run
```

## Testing

To run all tests:
```bash
cd ..
mvn test
```
