package com.transaction.manager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.manager.Repository.UserRepo;
import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Transactional	
	public void updateName(int id,String name)
	{
		userRepo.updateUserName(id, name);
		
	}
	

}
