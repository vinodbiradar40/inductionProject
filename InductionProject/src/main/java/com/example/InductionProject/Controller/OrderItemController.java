package com.example.InductionProject.Controller;


import com.example.InductionProject.Entities.OrderItem;
import com.example.InductionProject.Repository.OrderItemRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
	
	@Autowired
	private OrderItemRepo orderItemRepo;

	private static final Logger logger= LogManager.getLogger(OrderItemController.class);

	@PostMapping("createOrderItem")
	public boolean create(@RequestBody OrderItem orderItem)
	{
		orderItemRepo.save(orderItem);
		logger.info("OrderItems are Saved : {}", () -> orderItem);
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
