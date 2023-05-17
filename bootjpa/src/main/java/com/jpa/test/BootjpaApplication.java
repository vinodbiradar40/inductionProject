package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;


import com.jpa.test.dao.UserRepo;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaApplication {

	public static void main(String[] args) {
		
	SpringApplication.run(BootjpaApplication.class, args);
	
	
	}

}
