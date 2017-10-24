package com.practice.spring.springcorejavaconfig.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practice.spring.springcorejavaconfig.service.CustomerService;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//For Java Config- AnnotationConfigApplicationContext
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CustomerService service = appContext.getBean("customerService", CustomerService.class);
		
		System.out.println(service);
		
		CustomerService service2 = appContext.getBean("customerService", CustomerService.class);
		
		System.out.println(service2);
		
		System.out.println(service.findAll().get(0).getFirstName());
	}

}
