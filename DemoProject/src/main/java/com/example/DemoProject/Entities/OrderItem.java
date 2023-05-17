package com.example.DemoProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class OrderItem {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	@NotNull
	private int quantity;
	

	
	
	

}
