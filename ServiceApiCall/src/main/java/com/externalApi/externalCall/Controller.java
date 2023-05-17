package com.externalApi.externalCall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.externalApi.Details.PostOffice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class Controller 
{
	private EService eService;
		
	@Autowired
	public Controller(EService eService) {
		this.eService = eService;
	}

	
	@GetMapping("/pincode")
	public PostOffice get(@RequestParam(value="pincode") Integer pincode) throws JsonMappingException, JsonProcessingException
	{
		return eService.getValues(pincode);	
	}

}
