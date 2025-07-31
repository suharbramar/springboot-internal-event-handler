package com.bramar.spring.internaleventhandler.model;

import lombok.Getter;

@Getter
public class NotificationCreatedEvent extends AbstractDomainEvent {
    private final String notificationId;

    public NotificationCreatedEvent(String notificationId) {
        this.notificationId = notificationId;
    }
}
