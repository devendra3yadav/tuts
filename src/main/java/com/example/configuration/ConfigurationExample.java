package com.example.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration Example
 * 
 * Spring Boot Configuration Concepts:
 * 
 * 1. Convention over Configuration:
 *    - Spring Boot provides sensible defaults
 *    - Less configuration needed, more convention-based
 * 
 * 2. Auto-configuration:
 *    - Spring Boot automatically configures beans based on classpath
 *    - Detects dependencies and configures them automatically
 * 
 * 3. Externalized Configuration:
 *    - Configuration outside the code
 *    - Can be changed without recompiling
 * 
 * Configuration Sources (priority order):
 * 1. Command-line arguments (highest priority)
 * 2. Environment variables
 * 3. application-{profile}.yml
 * 4. application.yml
 * 5. Default values (lowest priority)
 */
@Configuration
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class ConfigurationExample {
    
    private Messaging messaging = new Messaging();
    private Kafka kafka = new Kafka();
    private Scheduling scheduling = new Scheduling();
    private Email email = new Email();
    
    @Getter
    @Setter
    public static class Messaging {
        private String queueName;
        private String topicName;
    }
    
    @Getter
    @Setter
    public static class Kafka {
        private String topicName;
    }
    
    @Getter
    @Setter
    public static class Scheduling {
        private String reportCron;
        private String cleanupCron;
    }
    
    @Getter
    @Setter
    public static class Email {
        private boolean enabled;
        private String from;
    }
}
