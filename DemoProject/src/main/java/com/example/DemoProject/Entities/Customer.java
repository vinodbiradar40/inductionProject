package com.example.DemoProject.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;

import lombok.Data;



@Entity
@Data
public class Customer 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@Size(max=20)
	private String phoneNo;
	@Min(value = 12) @Max(value = 95)
	private int age;
	@Email
	private String email;
	@NotNull
	private String address1;
	@NotEmpty
	private String address2;
	@NotNull
	private String country;
	@NotNull
	private String state;
	@NotNull
	private String city;
	@NotNull
	private String postalCode;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private List<Orders> orders;

	


}
