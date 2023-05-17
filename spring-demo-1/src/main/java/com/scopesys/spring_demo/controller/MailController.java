package com.scopesys.spring_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scopesys.spring_demo.mail.MailSender;
import com.scopesys.spring_demo.mail.MockMailSender;

@RestController
public class MailController 
{
	
	private MailSender mailSender;
	
		public MailController(@Qualifier("smtpMailSender") MailSender smtp) {
		this.mailSender = smtp;
	}





		@RequestMapping("/mail")
		public String mail()
		{
			mailSender.send("mail@example.com", "A test mail", "body of the test mail");
			
			return "Mail sent";
		}


}
