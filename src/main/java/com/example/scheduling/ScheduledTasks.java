package com.example.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduling Examples
 * 
 * What is Scheduling:
 * - Executing tasks at specific times or intervals
 * - Automating repetitive tasks without manual intervention
 * 
 * Why Scheduling is Used:
 * - Generate reports at regular intervals
 * - Clean up old data
 * - Send periodic emails/notifications
 * - Data synchronization
 * - Health checks and monitoring
 * 
 * Types:
 * - Time-based: Execute at specific times (cron expressions)
 * - Interval-based: Execute at fixed intervals
 */
@Component
@Slf4j
public class ScheduledTasks {
    
    /**
     * Fixed Rate - Interval-based execution
     * Executes every 5 seconds regardless of previous execution time
     * 
     * Use cases: Health checks, monitoring, periodic updates
     */
    @Scheduled(fixedRate = 5000)
    public void executeEveryFiveSeconds() {
        log.info("Executing task every 5 seconds - Current time: {}", 
                 System.currentTimeMillis());
    }
    
    /**
     * Fixed Delay - Interval-based execution
     * Waits for previous execution to complete, then waits 3 seconds
     * 
     * Use cases: When you need to ensure previous task completes before next
     */
    @Scheduled(fixedDelay = 3000)
    public void executeWithFixedDelay() {
        log.info("Executing task with 3 second delay after previous completion");
        // Simulate some work
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Cron Expression - Time-based execution
     * Cron: "second minute hour day month weekday"
     * 
     * This example: Every day at 2 AM
     * Use cases: Daily reports, cleanup jobs, backups
     */
    @Scheduled(cron = "0 0 2 * * *")
    public void dailyCleanup() {
        log.info("Executing daily cleanup at 2 AM");
        // Cleanup logic here
    }
    
    /**
     * Cron: Every Monday at 9 AM
     * Use cases: Weekly reports, weekly summaries
     */
    @Scheduled(cron = "0 0 9 * * MON")
    public void weeklyReport() {
        log.info("Generating weekly report every Monday at 9 AM");
        // Report generation logic here
    }
    
    /**
     * Cron: Every hour at minute 0
     * Use cases: Hourly data aggregation, hourly notifications
     */
    @Scheduled(cron = "0 0 * * * *")
    public void hourlyTask() {
        log.info("Executing hourly task");
        // Hourly logic here
    }
    
    /**
     * Initial Delay - Start after application starts
     * Executes 10 seconds after application startup, then every 30 seconds
     */
    @Scheduled(initialDelay = 10000, fixedRate = 30000)
    public void executeWithInitialDelay() {
        log.info("Executing task with initial delay");
    }
}
