package com.example.DemoProject.Controller;

import java.util.List;

import com.example.DemoProject.Entities.OrderItem;
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


import com.example.DemoProject.Entities.Product;
import com.example.DemoProject.Repository.ProductRepo;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private OrderItemRepo orderItemRepo;
	
	@PostMapping("createProduct")
	public boolean create(@RequestBody Product product)
	{
		productRepo.save(product);
		return true;
	}

	@GetMapping("readProductDetails")
	public List<Product> readDetails()
	{
		return productRepo.findAll();
	}
	
	@GetMapping("readProductDetails/{id}")
	public List<Product> readDetailsById(@PathVariable int id)
	{
		return productRepo.findAll();
	}
	
	@PutMapping("updateProductDetails/{id}")
	public boolean updateDetails(@PathVariable int id,@RequestBody Product product)
	{
		product.setProductId(id);
		productRepo.save(product);
		return true;
	}
	
	
	@DeleteMapping("deleteProductDetails/{id}")
	public boolean delete(@PathVariable int id)
	{
		productRepo.deleteById(id);
		return true;
	}



	//mapping the product to orderItem
	@PutMapping("/assignProduct/{orderItem_id}/{product_id}")
	public boolean assignProduct(@PathVariable int product_id,@PathVariable int orderItem_id)
	{
		Product product=productRepo.findById(product_id).get();
		OrderItem orderItem=orderItemRepo.findById(orderItem_id).get();
		product.getOrderItems().add(orderItem);
		productRepo.save(product);
		return true;
	}


	@PutMapping("/assignProduct")
	public boolean assignStudents(@RequestBody Product product)
	{
		productRepo.save(product);
		return true;
	}



}
