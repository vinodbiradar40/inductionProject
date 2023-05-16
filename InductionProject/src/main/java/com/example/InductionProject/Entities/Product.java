package com.example.InductionProject.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@NotNull
	private String productName;
	@NotNull
	private String productDescription;
	

	
}
