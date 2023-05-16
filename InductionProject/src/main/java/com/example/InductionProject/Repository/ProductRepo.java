package com.example.InductionProject.Repository;


import com.example.InductionProject.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
