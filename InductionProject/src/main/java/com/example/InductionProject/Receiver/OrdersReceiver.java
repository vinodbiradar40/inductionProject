package com.example.InductionProject.Receiver;


import com.example.InductionProject.Entities.Orders;
import com.example.InductionProject.Repository.OrdersRepo;
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
