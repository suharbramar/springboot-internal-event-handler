package com.bramar.spring.internaleventhandler.service;

import com.bramar.spring.internaleventhandler.model.OrderCreatedEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class OrderCreatedListenerImplTest {

    @Autowired
    private ApplicationEventPublisher publisher;

    @MockitoSpyBean
    private OrderCreatedListenerImpl orderCreatedListener;

    @Test
    void sholdHandleEligibleAndVipOrder() throws InterruptedException {
        //When publish a VIP oder event
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent("VIP1234");
        publisher.publishEvent(orderCreatedEvent);

        //Then the listener should process the event
        // Wait for the async processing to complete
        Thread.sleep(5000);

        // Verify that the listener processed the event
        verify(orderCreatedListener, times(1)).processEvent(orderCreatedEvent);
    }

    @Test
    void shouldNotHandleNonEligibleOrder() throws InterruptedException {
        // When publish a non-eligible order event
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent("NON_ELIGIBLE1234");
        publisher.publishEvent(orderCreatedEvent);

        // Then the listener should not process the event
        // Wait for the async processing to complete
        Thread.sleep(5000);

        // Verify that the listener did not process the event
        verify(orderCreatedListener, times(0)).processEvent(orderCreatedEvent);
    }

}