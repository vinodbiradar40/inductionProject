package com.example.DemoProject.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DemoProject.Entities.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders, Integer> {



}
