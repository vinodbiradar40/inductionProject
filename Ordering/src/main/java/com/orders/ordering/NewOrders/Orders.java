package com.orders.ordering.NewOrders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.orders.ordering.Orders.OrdersAPI;

import io.micrometer.common.lang.NonNull;



@Component
public class Orders 
{
	
	private int id;
	private String Oname;
	private String Odesc;
	private int quantity;
	
	
	
	public Orders() {
		
	}

	public Orders(int id, String oname, String odesc, int quantity) {
		super();
		this.id = id;
		Oname = oname;
		Odesc = odesc;
		this.quantity = quantity;
	}

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

	@Override
	public String toString() {
		return "Orders [id=" + id + ", Oname=" + Oname + ", Odesc=" + Odesc + ", quantity=" + quantity + "]";
	}

	

	
}
