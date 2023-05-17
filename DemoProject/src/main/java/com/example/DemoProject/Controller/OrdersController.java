package com.example.DemoProject.Controller;

import java.util.List;


import com.example.DemoProject.Entities.OrderItem;
import com.example.DemoProject.Receiver.OrdersReceiver;
import com.example.DemoProject.Repository.CustomerRepo;
import com.example.DemoProject.Repository.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoProject.Entities.Orders;
import com.example.DemoProject.Repository.OrdersRepo;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrdersRepo ordersRepo;

	@Autowired
	private OrdersReceiver ordersReceiver;

	@Autowired
	private OrderItemRepo orderItemRepo;

	@Autowired
	private CustomerRepo customerRepo;


	@PostMapping("/createOrders")
	public boolean create(@RequestBody Orders order)
	{
		ordersReceiver.receiveOrder(order);
		return true;
	}

	@GetMapping("/readOrdersDetails")
	public List<Orders> readDetails()
	{
		return ordersRepo.findAll();
	}
	
	@GetMapping("/readOrdersDetails/{id}")
	public List<Orders> readDetailsById(@PathVariable int id)
	{
		return ordersRepo.findAll();
	}
	
	@PutMapping("/updateOrdersDetails/{id}")
	public boolean updateDetails(@PathVariable int id,@RequestBody Orders orders)
	{
		orders.setId(id);
		ordersRepo.save(orders);
		return true;
	}
	
	
	@DeleteMapping("/deleteOrdersDetails/{id}")
	public boolean delete(@PathVariable int id)
	{
		ordersRepo.deleteById(id);
		return true;
	}


	//mapping the orders to orderItem

	@PutMapping("/assignOrder/{orderItem_id}/{order_id}")
	public boolean assignOrder(@PathVariable int order_id,@PathVariable int orderItem_id)
	{
		Orders orders=ordersRepo.findById(order_id).get();
		OrderItem orderItem=orderItemRepo.findById(orderItem_id).get();
		orders.getOrderItems().add(orderItem);
		ordersRepo.save(orders);
		return true;
	}

	@PutMapping("/assignOrder")
	public boolean assignStudents(@RequestBody Orders orders)
	{
		ordersRepo.save(orders);
		return true;
	}






}
