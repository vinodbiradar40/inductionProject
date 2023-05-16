package com.example.InductionProject.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class OrderItem {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	@NotNull
	private int quantity;
	@NotNull
	private int productId;
	

}
