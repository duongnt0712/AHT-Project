package com.aht.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aht.hellospring.config.AppConfiguration;
import com.aht.hellospring.entity.HelloWorld;

public class MainApp {
	public static void main(String[] args) {
		// Config using xml file
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld object = (HelloWorld) context.getBean("helloWorld");
		object.getMessage();	
		
		//Config using annotation
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		HelloWorld obj = ctx.getBean(HelloWorld.class);
		obj.setMessage("Hello World from config file");
		obj.getMessage();
		
		//Event handling
		ConfigurableApplicationContext configctx = new ClassPathXmlApplicationContext("Beans.xml");
		
		//start event
		configctx.start();
		
		object.getMessage();
		
		//stopped event
		configctx.stop();
	}
}
