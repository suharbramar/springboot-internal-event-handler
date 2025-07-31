package com.bramar.spring.completablefuture.service;

import java.util.concurrent.CompletableFuture;

public interface ReportService {

    CompletableFuture<String> generateReport(String reportId) throws InterruptedException;
}
