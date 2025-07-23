package com.bramar.spring.internaleventhandler.service;

import com.bramar.spring.internaleventhandler.model.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final ApplicationEventPublisher eventPublisher;

    public OrderServiceImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void createOrder(String orderId) {
        log.info("Creating order with ID: " + orderId);
        eventPublisher.publishEvent(new OrderCreatedEvent(orderId));
    }
}
