package com.metacube.training.shape;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
//@Component("mockMail")
//@Primary
public class MockMailSender implements IMailSender{

	@Override
	public void send() {
		System.out.println("Mock Mail sent");
	}

}
