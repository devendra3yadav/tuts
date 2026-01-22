# 2. Scheduling

This directory contains examples for understanding task scheduling in enterprise applications.

## Files

- `ScheduledTasks.java` - Comprehensive examples of different scheduling patterns

## Key Concepts

- **Time-based scheduling**: Using cron expressions
- **Interval-based scheduling**: Using fixedRate and fixedDelay
- **Real-world use cases**: Reports, cleanup, emails

## Study Order

1. Read `ScheduledTasks.java` to understand different scheduling patterns
2. Note the differences between:
   - `@Scheduled(fixedRate = ...)` - Executes at fixed intervals
   - `@Scheduled(fixedDelay = ...)` - Waits after previous execution
   - `@Scheduled(cron = ...)` - Time-based execution
3. Understand cron expression format: `second minute hour day month weekday`
