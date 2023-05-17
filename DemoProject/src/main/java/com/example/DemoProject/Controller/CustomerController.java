package com.example.DemoProject.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.DemoProject.Entities.Orders;
import com.example.DemoProject.Repository.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoProject.Entities.Customer;

import com.example.DemoProject.Repository.CustomerRepo;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrdersRepo ordersRepo;

	@PostMapping("/createCustomerDetail")
	public boolean create(@Valid @RequestBody Customer customerDetails)
	{
		customerRepo.save(customerDetails);
		return true;
	}

	@GetMapping("/readCustomerDetails")
	public List<Customer> readDetails()
	{
		return customerRepo.findAll();
	}
	
	@GetMapping("/readCustomerDetails/{id}")
	public List<Customer> readDetailsById(@PathVariable int id)
	{
		return customerRepo.findAll();
	}
	
	@GetMapping("/readCustomer/{id}")
	public ResponseEntity<Customer> getUser(@PathVariable int id)
	{

		Customer customer=customerRepo.findById(id).get();
		if(customer == null)
		{
			throw new NoSuchElementException(" User with this "+id+" not found ");
		}
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomerDetails/{id}")
	public boolean updateDetails(@PathVariable int id,@RequestBody Customer customer)
	{
		customer.setCustomerId(id);
		customerRepo.save(customer);
		return true;
	}
	
	
	@DeleteMapping("deleteCustomerDetails/{id}")
	public boolean delete(@PathVariable int id)
	{
		customerRepo.deleteById(id);
		return true;
	}


	//mapping the customer to orders

	@PutMapping("/assignCustomer/{order_id}/{customer_id}")
	public boolean assignCustomer(@PathVariable int customer_id,@PathVariable int order_id)
	{
		Customer customer=customerRepo.findById(customer_id).get();
		Orders order=ordersRepo.findById(order_id).get();
		customer.getOrders().add(order);
		customerRepo.save(customer);
		return true;
	}

	@PutMapping("/assignCustomer")
	public boolean assignStudents(@RequestBody Customer customer)
	{
		customerRepo.save(customer);
		return true;
	}


	//to get name
	@GetMapping("/readCustomerName/{id}")
	public String getNameDetails(@PathVariable int id)
	{
		return customerRepo.getName(id);
	}

	//get name with their order and their status
	@GetMapping("/readCustomerWithOrderDetails/{id}")
	public List<Object[]> getCODetails(@PathVariable int id)
	{
		return customerRepo.findCustomerAndOrdersByCustomerId(id);
	}

	//to update phone no using transactional

	@PutMapping("/updatePhoneNo/{id}/{phone}")
	public boolean updateNo(@PathVariable int id,@PathVariable String phone)
	{
		customerRepo.updatePhoneNumber(id,phone);
		return true;
	}

}
