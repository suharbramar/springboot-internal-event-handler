package com.bramar.spring.completablefuture.controller;

import com.bramar.spring.completablefuture.service.ReportService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/{reportId}")
    public CompletableFuture<String> generateReport(@PathVariable String reportId) throws InterruptedException {
        return reportService.generateReport(reportId);
    }
}
