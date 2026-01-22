package com.example.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller demonstrating different ways to access configuration
 */
@RestController
@RequestMapping("/api/config")
@RequiredArgsConstructor
public class ConfigurationController {
    
    // Method 1: @Value annotation for simple properties
    @Value("${spring.application.name}")
    private String applicationName;
    
    @Value("${app.email.enabled}")
    private boolean emailEnabled;
    
    // Method 2: Environment object for programmatic access
    private final Environment environment;
    
    // Method 3: @ConfigurationProperties for complex objects
    private final ConfigurationExample configurationExample;
    
    @GetMapping("/simple")
    public Map<String, Object> getSimpleConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put("applicationName", applicationName);
        config.put("emailEnabled", emailEnabled);
        return config;
    }
    
    @GetMapping("/environment")
    public Map<String, Object> getConfigFromEnvironment() {
        Map<String, Object> config = new HashMap<>();
        config.put("activeProfiles", environment.getActiveProfiles());
        config.put("dbUrl", environment.getProperty("spring.datasource.url"));
        config.put("kafkaBootstrapServers", 
                   environment.getProperty("spring.kafka.bootstrap-servers"));
        return config;
    }
    
    @GetMapping("/complex")
    public ConfigurationExample getComplexConfig() {
        return configurationExample;
    }
    
    @GetMapping("/profile")
    public Map<String, String> getActiveProfile() {
        Map<String, String> profile = new HashMap<>();
        profile.put("activeProfile", 
                   environment.getActiveProfiles().length > 0 
                       ? environment.getActiveProfiles()[0] 
                       : "default");
        return profile;
    }
}
