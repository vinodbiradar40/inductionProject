package com.example.DemoProject.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DemoProject.Entities.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {



}
