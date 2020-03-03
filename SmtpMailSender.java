package com.metacube.training.shape;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Component("smtpMail")
@Primary
public class SmtpMailSender implements IMailSender {

	@Override
	public void send() {
		System.out.println("Smtp Mail Sent");
	}

}
