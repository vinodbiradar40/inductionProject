package com.example.InductionProject.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "orders")
@Data
public class Orders {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderId")
	private int Id;
	@NotNull
	@Column(name = "orderDate")
	private String oDate;
	@NotNull
	private String shippedDate;
	@NotNull
	@Column(name = "orderStatus")
	private String ostatus;
	@NotEmpty
	private String comment;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private  List<OrderItem> orderItems;



	
	
	
	
	

}
