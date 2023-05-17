package com.example.demo.ActiveMqDemo.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publish {
	
	
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void publishMessage() throws Exception
	{
		
			jmsTemplate.convertAndSend("demo","hi");
			
		
	}

}
