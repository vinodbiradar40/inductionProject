package com.external_api.ApiController;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestApiController 
{
	Scanner scanner=new Scanner(System.in);
	String pinCode=scanner.next();
	
	
	@GetMapping("/pin")
	private String getPin()
	{
		String url="https://api.postalpincode.in/pincode/"+pinCode;
		RestTemplate restTemplate=new RestTemplate();
		String result=restTemplate.getForObject(url, String.class);
		     
		return result;
	}
	
	
	
}
