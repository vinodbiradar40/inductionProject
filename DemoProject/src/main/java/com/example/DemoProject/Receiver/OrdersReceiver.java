package com.example.DemoProject.Receiver;

import com.example.DemoProject.Entities.Orders;
import com.example.DemoProject.Repository.OrdersRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrdersReceiver {

    @Autowired
    private OrdersRepo ordersRepo;

    @JmsListener(destination = "orders")
    public void receiveOrder(Orders order) {
        ordersRepo.save(order);
    }
}
