package com.example.InductionProject.Repository;



import com.example.InductionProject.Entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {



}
