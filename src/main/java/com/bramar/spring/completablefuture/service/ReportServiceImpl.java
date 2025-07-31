package com.bramar.spring.completablefuture.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class ReportServiceImpl implements ReportService {

    @Override
    @Async("reportGenerationExecutor")
    public CompletableFuture<String> generateReport(String reportId) throws InterruptedException {
        log.info("Generating report with ID: {}", reportId);
        //System.out.println("[Thread : "+Thread.currentThread().getName() + "] Generating report with ID: " + reportId);
        Thread.sleep(3000); // Simulate a long-running task
        return CompletableFuture.completedFuture("Report with ID: " + reportId + " completed");
    }
}
