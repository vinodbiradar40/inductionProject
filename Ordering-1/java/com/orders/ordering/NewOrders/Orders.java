package com.orders.ordering.NewOrders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;



import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



@Component
public class Orders 
{
	@NotNull 
	private int id;
	@NotEmpty
	@Size(min=2,message = "usename should be of 2 characters")
	private String Oname;
	@Min(12)
	@Max(100)
	private int age;
	@NotNull
	@Pattern(regexp = "^\\d{10}$",message = "It should contain 10 digit no.")
	private String phoneNo;
	@NotEmpty
	@Email(message = "It should be in correct format",regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	@NotEmpty
	private String Odesc;
	@NotNull
	private int quantity;
	@NotBlank
	private String country;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOname() {
		return Oname;
	}
	public void setOname(String oname) {
		Oname = oname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOdesc() {
		return Odesc;
	}
	public void setOdesc(String odesc) {
		Odesc = odesc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", Oname=" + Oname + ", age=" + age + ", phoneNo=" + phoneNo + ", email=" + email
				+ ", Odesc=" + Odesc + ", quantity=" + quantity + ", country=" + country + "]";
	}

	
}
