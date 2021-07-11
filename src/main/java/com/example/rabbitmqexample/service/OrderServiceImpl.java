package com.example.rabbitmqexample.service;

import com.example.rabbitmqexample.model.Order;
import com.example.rabbitmqexample.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @RabbitListener(queues = "order-queue", concurrency = "5")
    public void processOrder (Order order) {

        waitRandom();

        orderRepository.save(order);
        log.info("Received order: " + order.toString());

    }

    private void waitRandom () {
        try {
            long ms = 2000 + 50 * new Random().nextInt(10);
            log.info("Waiting {} milliseconds for simulating...", ms);
            Thread.sleep(ms);
        } catch (Exception e)  {
            log.error(e.getMessage(), e);
        }
    }

}
