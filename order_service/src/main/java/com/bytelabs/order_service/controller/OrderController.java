package com.bytelabs.order_service.controller;

import com.bytelabs.order_service.dto.OrderDto;
import com.bytelabs.order_service.entity.OrderEntity;
import com.bytelabs.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(OrderDto order) {
        OrderEntity t = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(t);
    }
}
