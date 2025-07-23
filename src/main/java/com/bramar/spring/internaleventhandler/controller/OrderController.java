package com.bramar.spring.internaleventhandler.controller;

import com.bramar.spring.internaleventhandler.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> createOrder(@PathVariable String id){
        orderService.createOrder(id);
        return ResponseEntity.ok("Order created successfully");
    }
}
