package com.bramar.spring.internaleventhandler.model;

import lombok.Getter;

@Getter
public class OrderCreatedEvent extends AbstractDomainEvent {
    private final String orderId;

    public OrderCreatedEvent(String orderId) {
        super();
        this.orderId = orderId;
    }
}
