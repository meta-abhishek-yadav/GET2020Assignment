package com.metacube.training.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.training.shape.*;

@Configuration
public class AppConfig {

	@Bean("smtp")
	public SmtpMailSender smtpMail() {
		return new SmtpMailSender();
	}
	
	@Bean("mock")
	public MockMailSender mockMail() {
		return new MockMailSender();
	}
	
}
