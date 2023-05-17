package com.externalApi.Details;

import org.springframework.stereotype.Component;

import com.google.gson.annotations.SerializedName;


public class PostOffice 
{
	@SerializedName("Name")
	private String name;
	
	@SerializedName("District")
	private String district;
	
	@SerializedName("State")
	private String state;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	
	
}
