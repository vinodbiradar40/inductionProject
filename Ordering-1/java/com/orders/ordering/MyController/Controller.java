package com.orders.ordering.MyController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orders.ordering.NewOrders.Orders;

import jakarta.validation.Valid;



@RestController
public class Controller 
{
	@Autowired
	private Orders orders;
	
	
	private List<Orders> orderList=new ArrayList<>();

	
	@GetMapping("/allOrders")
	public List<Orders> getOrders()
	{
		return orderList;
	}
	
	@PostMapping("/createOrders")	
	public boolean postOrders(@RequestBody @Valid Orders order ) 
	{
		orderList.add(order);
		return true;
	}
	
	@GetMapping("/allOrders/{orderId}")
	public Orders getIdOrders(@PathVariable int orderId) 
	{
		Orders orders=null;
		for(Orders ord : orderList)
		{
			if(ord.getId() == orderId)
			{
				orders=ord;
			}
			else {
				{
					throw new  HttpMessageNotReadableException("No Order found with this id");
				}
			}
				
		}
		return orders;
	}
	
	@PutMapping("/putOrders/{putId}")
	public Orders putOrder(@PathVariable int putId,@RequestBody Orders ord)  
	{
		
			Orders odOrders=orderList.get(putId);
			
			odOrders.setOname(ord.getOname());
			odOrders.setOdesc(ord.getOdesc());
			odOrders.setQuantity(ord.getQuantity());
			odOrders.setAge(ord.getAge());
			odOrders.setPhoneNo(ord.getPhoneNo());
			odOrders.setEmail(ord.getEmail());
			odOrders.setCountry(ord.getCountry());
			
			return odOrders;
				
		
	}
	
	@DeleteMapping("/deleteOrders/{id}")
	public boolean deleteOrder(@PathVariable long id)
	{
		boolean isRemoved = orderList.removeIf(ord -> ord.getId() == id);
	       if (isRemoved) {
	           return true;
	       } 
		return false;
	
	}
	
}
