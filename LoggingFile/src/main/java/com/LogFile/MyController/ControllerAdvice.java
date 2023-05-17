package com.LogFile.MyController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ControllerAdvice 
{
	
	
	private static final Logger logger=LogManager.getLogger(ControllerAdvice.class);
	
	
	
	
	@GetMapping("/hello")
	public String hello()
	{
		logger.debug("Debug log");
		logger.info("Console log");
		logger.warn("Warning");
		
		return "Welcome to Log!";
	}
	
	

}
