package com.bramar.spring.internaleventhandler.filter;

import com.bramar.spring.internaleventhandler.model.OrderCreatedEvent;
import org.springframework.stereotype.Component;

@Component("orderFilter")
public class OrderFilter {

    public boolean isVipOrder(String orderId) {
        return orderId.startsWith("VIP");
    }

    public boolean isOrderEligible(OrderCreatedEvent event) {
        return event.getOrderId().length() > 3;
    }
}
