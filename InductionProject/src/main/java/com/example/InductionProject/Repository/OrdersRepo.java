package com.example.InductionProject.Repository;



import com.example.InductionProject.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders, Integer> {



}
