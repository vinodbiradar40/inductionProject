package com.example.InductionProject.Controller;


import com.example.InductionProject.Entities.Product;
import com.example.InductionProject.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;




	
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







}
