package com.bramar.spring.internaleventhandler.service;

import com.bramar.spring.internaleventhandler.model.NotificationCreatedEvent;
import com.bramar.spring.internaleventhandler.model.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService {

    private final ApplicationEventPublisher eventPublisher;

    public NotificationServiceImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void createNotification(String notificationId) {
        log.info("Creating notification with ID: {}", notificationId);
        eventPublisher.publishEvent(new NotificationCreatedEvent(notificationId));
    }

}
