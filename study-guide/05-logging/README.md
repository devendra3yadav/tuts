# 5. Logging

This directory contains examples for understanding logging in enterprise applications.

## Files

- `LoggingExample.java` - Demonstrates all log levels and best practices

## Key Concepts

- **What is logging**: Recording events and messages during execution
- **Purpose of logging**: Debugging, monitoring, auditing, troubleshooting
- **Log levels**: TRACE, DEBUG, INFO, WARN, ERROR, FATAL
- **Logging in production**: Importance and best practices
- **Structured logging**: Including context information

## Study Order

1. Read `LoggingExample.java` to see all log levels in action
2. Understand when to use each log level:
   - TRACE: Very detailed (development only)
   - DEBUG: Detailed debugging information
   - INFO: General information
   - WARN: Warnings
   - ERROR: Errors
3. Note best practices:
   - Include context (user ID, request ID)
   - Don't log sensitive information
   - Use appropriate log levels
