package com.bramar.spring.internaleventhandler.service;

import com.bramar.spring.internaleventhandler.model.NotificationCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class NotificationCreatedListenerImpl extends GenericEventListener<NotificationCreatedEvent> {

    Logger log = LoggerFactory.getLogger(NotificationCreatedListenerImpl.class);

    @Override
    @Async("notificationEventProcessingExecutor")
    @EventListener(condition = "#event.notificationId == 'VIP123'")
    public void processEvent(NotificationCreatedEvent event) {
        // Simulate a delay to mimic processing time
        log.info("Processing notification event asynchronously for ID: {}", event.getNotificationId());
        try {
            log.info("Thread Sleep..");
            Thread.sleep(5000); // 5 seconds delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            throw new RuntimeException("Notification processing interrupted", e);
        }

        // Log the event details
        log.info("Notification created event received: {}", event.getNotificationId());
    }

    @Override
    protected Class<NotificationCreatedEvent> getEventType() {
        return NotificationCreatedEvent.class;
    }

}
