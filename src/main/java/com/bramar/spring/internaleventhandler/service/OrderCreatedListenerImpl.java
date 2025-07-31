package com.bramar.spring.internaleventhandler.service;

import com.bramar.spring.internaleventhandler.model.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class OrderCreatedListenerImpl extends GenericEventListener<OrderCreatedEvent> {

    Logger log = LoggerFactory.getLogger(OrderCreatedListenerImpl.class);

    @Override
    @Async("orderEventProcessingExecutor")
    @EventListener(condition = "@orderFilter.isOrderEligible(#event) && @orderFilter.isVipOrder(#event.orderId)")
    public void processEvent(OrderCreatedEvent event) {
        // Simulate a delay to mimic processing time
        log.info("Processing order created event asynchronously for ID: {}", event.getOrderId());
        try {
            log.info("Thread Sleep..");
            Thread.sleep(5000); // 5 seconds delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            throw new RuntimeException("Order processing interrupted", e);
        }

        // Log the event details
        log.info("Order created event received: {}", event.getOrderId());
    }

    @Override
    protected Class<OrderCreatedEvent> getEventType() {
        return OrderCreatedEvent.class;
    }

}
