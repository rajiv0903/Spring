package com.practice.spring.springcorexml.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.spring.springcorexml.service.CustomerService;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService service = appContext.getBean("customerService", CustomerService.class);
		System.out.println(service);
		CustomerService service2 = appContext.getBean("customerService", CustomerService.class);
		System.out.println(service2);
		System.out.println(service.findAll().get(0).getFirstName());
	}

}
