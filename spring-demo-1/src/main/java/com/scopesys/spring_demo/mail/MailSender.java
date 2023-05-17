package com.scopesys.spring_demo.mail;

public interface MailSender 
{
	 void send(String to,String subject,String body);

}
