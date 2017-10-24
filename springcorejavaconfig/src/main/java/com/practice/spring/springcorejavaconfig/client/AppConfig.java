package com.practice.spring.springcorejavaconfig.client;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configurable
@ComponentScan("com.practice.spring.springcorejavaconfig")
@PropertySource("app.properties")
public class AppConfig {
	
	//To load Properties
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// Return Bean to Application
/*	@Bean(name = "customerService")
	public CustomerService getCustomerService() {
		//Setter Injection
		CustomerServiceImpl service = new CustomerServiceImpl();
		service.setCustomerRepository(getCustomerRepository());
		return service;
		
		//Constructor Injection
		CustomerServiceImpl service = new CustomerServiceImpl(getCustomerRepository());
		return service;
		
		//To use Autowired
		CustomerServiceImpl service = new CustomerServiceImpl();
		return service;
	}*/

	// Return Bean to Application
/*	@Bean(name = "customerRepository")
	public CustomerRepository getCustomerRepository() {
		return new CustomerRepositoryImpl();
	}*/

}
