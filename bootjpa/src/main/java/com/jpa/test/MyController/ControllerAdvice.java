package com.jpa.test.MyController;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.dao.UserRepo;
import com.jpa.test.entities.User;



@RestController
public class ControllerAdvice 
{
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("/createUsers")
	public void addUser(@RequestBody User user)
	{
		User users=userRepo.save(user);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers()
	{
		return (List<User>) userRepo.findAll();
	}
	
	@GetMapping("/getUserId/{id}")
	public User getId(@PathVariable int id)
	{
		Optional<User> usersOptional=userRepo.findById(id);
		
		return usersOptional.get();
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id)
	{
		user.setId(id);
		userRepo.save(user);
		
		return ResponseEntity.ok().build();
		
	}
	
	
	
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id)
	{
		userRepo.deleteById(id);
	}

}
