package com.example.DemoProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoProject.Entities.OrderItem;
import com.example.DemoProject.Repository.OrderItemRepo;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
	
	@Autowired
	private OrderItemRepo orderItemRepo;
	

	@PostMapping("createOrderItem")
	public boolean create(@RequestBody OrderItem orderItem)
	{
		orderItemRepo.save(orderItem);
		return true;
	}

	@GetMapping("readOrderItemDetails")
	public List<OrderItem> readDetails()
	{
		return orderItemRepo.findAll();
	}
	
	@GetMapping("readOrderItemDetails/{id}")
	public List<OrderItem> readDetailsById(@PathVariable int id)
	{
		return orderItemRepo.findAll();
	}
	
	@PutMapping("updateOrderItemDetails/{id}")
	public boolean updateDetails(@PathVariable int id,@RequestBody OrderItem orderItem)
	{
		orderItem.setOrderItemId(id);
		orderItemRepo.save(orderItem);
		return true;
	}
	
	
	@DeleteMapping("deleteOrderItemDetails/{id}")
	public boolean delete(@PathVariable int id)
	{
		orderItemRepo.deleteById(id);
		return true;
	}
	




		

	
	
}
