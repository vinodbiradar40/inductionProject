package com.externalApi.externalCall;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.externalApi.Details.PostOffice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EService 
{

	private RestTemplate restTemplate;
	
	
	

	@Autowired
	public EService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public PostOffice getValues(Integer pin) throws JsonMappingException, JsonProcessingException, NullPointerException
	{
		String postalString=restTemplate.getForObject("https://api.postalpincode.in/pincode/"+pin, String.class);
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=mapper.readTree(postalString);
		
		
//        JsonNode locationNode = node.get(0).get("PostOffice").get(0).get("Name"); 
//        String location = locationNode.asText();
		
		
		List<PostOffice> offices=new ArrayList<>();
		node.get(0).get("PostOffice").forEach((postNode) ->{
			
			PostOffice office=new PostOffice();
			office.setName(postNode.get("Name").asText());
			office.setDistrict(postNode.get("District").asText());
			office.setState(postNode.get("State").asText());
			offices.add(office);
			
		});
		
		return  offices.get(2);
	}
	
	
}
