package com.bramar.spring.internaleventhandler.service;

import com.bramar.spring.internaleventhandler.model.NotificationCreatedEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class NotificationCreatedListenerImplTest {

    @Autowired
    private ApplicationEventPublisher publisher;

    @MockitoSpyBean
    private NotificationCreatedListenerImpl notificationCreatedListener;

    @Test
    void shouldHandleVipOrder() throws InterruptedException {
        // When publish a VIP order event
        NotificationCreatedEvent notificationCreatedEvent = new NotificationCreatedEvent("VIP123");
        publisher.publishEvent(notificationCreatedEvent);

        // Then the listener should process the event
        // Wait for the async processing to complete
        Thread.sleep(5000);

        // Verify that the listener processed the event
        verify(notificationCreatedListener, times(1)).processEvent(notificationCreatedEvent);
    }

    @Test
    void shouldNotHandleNonVipOrder() throws InterruptedException {
        // When publish a non-VIP order event
        NotificationCreatedEvent notificationCreatedEvent = new NotificationCreatedEvent("NON_VIP123");
        publisher.publishEvent(notificationCreatedEvent);

        // Then the listener should not process the event
        // Wait for the async processing to complete
        Thread.sleep(5000);

        // Verify that the listener did not process the event
        verify(notificationCreatedListener, never()).processEvent(notificationCreatedEvent);
    }

}