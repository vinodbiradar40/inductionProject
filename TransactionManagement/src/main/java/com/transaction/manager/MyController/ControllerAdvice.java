package com.transaction.manager.MyController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.manager.Service.UserService;
import com.transaction.manager.UserDetails.User;

@RestController
public class ControllerAdvice {
	
	@Autowired
	private UserService userService;
	
	@PutMapping("/updateName/{id}")
	public boolean updateDetails(@PathVariable int id,@RequestBody User user)
	{
		userService.updateName(id, user.getName());
		return true;
		
	}

}
