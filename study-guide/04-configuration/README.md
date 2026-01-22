# 4. Spring Boot Configuration

This directory contains examples for understanding Spring Boot configuration.

## Files

- `ConfigurationExample.java` - Demonstrates @ConfigurationProperties
- `ConfigurationController.java` - Shows different ways to access configuration
- `application.yml` - Main configuration file
- `application-dev.yml` - Development profile configuration
- `application-prod.yml` - Production profile configuration

## Key Concepts

- **Convention over Configuration**: Spring Boot's sensible defaults
- **Auto-configuration**: Automatic bean configuration
- **Externalized Configuration**: Configuration outside code
- **Configuration Sources**: Priority order of configuration
- **Environment-specific Configuration**: Different configs for dev/test/prod

## Study Order

1. Read `application.yml` to understand basic configuration
2. Compare `application-dev.yml` and `application-prod.yml` for environment differences
3. Read `ConfigurationExample.java` to see @ConfigurationProperties usage
4. Read `ConfigurationController.java` to see different ways to access config:
   - @Value annotation
   - Environment object
   - @ConfigurationProperties
