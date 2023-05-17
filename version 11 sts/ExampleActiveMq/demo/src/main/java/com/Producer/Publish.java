package com.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class Publish {

    @Autowired
	private JmsTemplate jmsTemplate;
	
	public String publishMessage()
	{
		try {
			jmsTemplate.convertAndSend("demo", "Hello, ActiveMQ!");
			return "sent";
		} catch (Exception e) {
			return "failed";
		}
	}
    
}
