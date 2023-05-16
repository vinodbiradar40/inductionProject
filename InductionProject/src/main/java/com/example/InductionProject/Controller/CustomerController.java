package com.example.InductionProject.Controller;


import com.example.InductionProject.Entities.Customer;
import com.example.InductionProject.Entities.Orders;
import com.example.InductionProject.ExceptionHandler.UserNotFoundException;
import com.example.InductionProject.Repository.CustomerRepo;
import com.example.InductionProject.Repository.OrdersRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;


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
	public String getUser(@Valid @PathVariable int id)throws UserNotFoundException
	{
		Customer customer = customerRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with this id is not present"));
		return "Found";
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


	//to get name using nativeQuery
	@GetMapping("/readCustomerName/{id}")
	public String getNameDetails(@PathVariable int id)
	{
		return customerRepo.getName(id);
	}

	//to get details of users from particular city using namedQuery
	@GetMapping("/{city}")
	public String getDetails(@PathVariable String city)
	{
		return customerRepo.findByCity(city);
	}


	//to get customers order-list by using jpa named properties
	@GetMapping("/nameDetails/{phoneNo}")
	public String getCustomerDetails(@PathVariable String phoneNo)
	{
		Customer customer=customerRepo.findByPhoneNo(phoneNo);
		String fName=customer.getFirstName();
		String lName=customer.getLastName();
		return fName +" "+ lName ;

	}

	//to update phone no using transactional
	@PutMapping("/updatePhoneNo/{id}/{phone}")
	public boolean updateNo(@PathVariable int id,@PathVariable String phone)
	{
		customerRepo.updatePhoneNumber(id,phone);
		return true;
	}

}
