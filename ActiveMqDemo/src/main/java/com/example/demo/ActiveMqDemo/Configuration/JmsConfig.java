package com.example.demo.ActiveMqDemo.Configuration;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;



@Configuration
@EnableJms
public class JmsConfig {

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory=new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        return jmsListenerContainerFactory;
    }
	
	@Bean
	public MessageConverter messageConverter()
	{
		return new SimpleMessageConverter();
	}
	
	
}