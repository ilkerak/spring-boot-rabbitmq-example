package com.example.rabbitmqexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.QueueInformation;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final RabbitAdmin rabbitAdmin;

    @GetMapping("/queue/{queue-name}/info")
    public ResponseEntity<QueueInformation> addOrderQueue (@PathVariable("queue-name") String queueName) {
        QueueInformation queueInfo = rabbitAdmin.getQueueInfo(queueName);
        return ResponseEntity.ok(queueInfo);
    }
}
