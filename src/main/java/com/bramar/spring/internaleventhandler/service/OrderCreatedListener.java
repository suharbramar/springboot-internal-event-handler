package com.bramar.spring.internaleventhandler.service;

import com.bramar.spring.internaleventhandler.model.OrderCreatedEvent;

public interface OrderCreatedListener {

    void handleOrderCreated(OrderCreatedEvent orderCreatedEvent);
}
