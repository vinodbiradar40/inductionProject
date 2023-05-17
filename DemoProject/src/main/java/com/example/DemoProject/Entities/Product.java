package com.example.DemoProject.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@NotNull
	private String productName;
	@NotNull
	private String productDescription;
	
	@OneToMany
	@JoinColumn(name = "productId")
	private List<OrderItem> orderItems;

	
}