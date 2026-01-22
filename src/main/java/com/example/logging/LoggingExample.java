package com.example.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Logging Examples
 * 
 * What is Logging:
 * - Recording events, messages, and errors that occur during application execution
 * - Provides visibility into application behavior
 * 
 * Purpose of Logging:
 * - Debugging: Identify and fix issues
 * - Monitoring: Track application health and performance
 * - Auditing: Record important business events
 * - Troubleshooting: Diagnose problems in production
 * 
 * Log Levels (from lowest to highest):
 * - TRACE: Very detailed information, typically only for development
 * - DEBUG: Detailed information for debugging
 * - INFO: General informational messages about application flow
 * - WARN: Warning messages for potentially harmful situations
 * - ERROR: Error events that might still allow application to continue
 * - FATAL: Severe errors that might cause application to abort
 */
@Service
@Slf4j
public class LoggingExample {
    
    public void demonstrateLogLevels() {
        // TRACE: Most verbose, usually disabled in production
        log.trace("This is a TRACE level message - very detailed information");
        
        // DEBUG: Useful for development and troubleshooting
        log.debug("This is a DEBUG level message - detailed debugging information");
        
        // INFO: General information about application flow
        log.info("This is an INFO level message - application is running normally");
        
        // WARN: Warning about potential issues
        log.warn("This is a WARN level message - something unexpected but not critical");
        
        // ERROR: Error occurred but application can continue
        log.error("This is an ERROR level message - an error occurred");
    }
    
    public void logWithContext(String userId, String action) {
        // Logging with context information
        log.info("User {} performed action: {}", userId, action);
    }
    
    public void logException(Exception e) {
        // Logging exceptions with stack trace
        log.error("An error occurred while processing request", e);
    }
    
    public void logBusinessEvent(String eventType, Object data) {
        // Logging business events for auditing
        log.info("Business event: {} - Data: {}", eventType, data);
    }
    
    /**
     * Best Practices:
     * - Use appropriate log levels
     * - Include context (user ID, request ID, etc.)
     * - Don't log sensitive information (passwords, tokens)
     * - Use structured logging when possible
     * - Log exceptions with full stack traces
     * - Use different log levels for different environments
     */
}
