package com.example.DemoProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DemoProject.Entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
