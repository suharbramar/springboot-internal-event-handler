package com.bramar.spring.internaleventhandler.controller;

import com.bramar.spring.internaleventhandler.service.NotificationService;
import com.bramar.spring.internaleventhandler.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> createNotification(@PathVariable String id){
        notificationService.createNotification(id);
        return ResponseEntity.ok("Notification is sent successfully");
    }
}
