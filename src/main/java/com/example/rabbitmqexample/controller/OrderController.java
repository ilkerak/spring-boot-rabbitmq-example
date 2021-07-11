package com.example.rabbitmqexample.controller;

import com.example.rabbitmqexample.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/add")
    public ResponseEntity<String> addOrderQueue (@RequestBody Order order) {
        rabbitTemplate.convertAndSend("order-queue", order );
        return ResponseEntity.ok("Order received successfully at " + new Date());
    }
}
