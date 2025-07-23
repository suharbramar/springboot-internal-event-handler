package com.bramar.spring.internaleventhandler.service;

import com.bramar.spring.internaleventhandler.model.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreatedListenerImpl implements OrderCreatedListener {

    @Override
    @Async
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent orderCreatedEvent) {
        // Simulate a delay to mimic processing time
        log.info("Processing order created event asynchronously for ID: " + orderCreatedEvent.getOrderId());
        try {
            Thread.sleep(10000); // 5 seconds delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            throw new RuntimeException("Order processing interrupted", e);
        }

        // Log the event details
        log.info("Order created event received: " + orderCreatedEvent.getOrderId());
    }
}
