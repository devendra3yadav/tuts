package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main Spring Boot Application
 * 
 * @EnableScheduling - Enables Spring's scheduled task execution capability
 */
@SpringBootApplication
@EnableScheduling
public class EnterpriseApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EnterpriseApplication.class, args);
    }
}
