package com.aht.hellospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aht.hellospring.entity.HelloWorld;

@Configuration
public class AppConfiguration {
	
	@Bean
	public HelloWorld getMessage() {
		return new HelloWorld();
	}
}
