package com.practice.spring.springcorexml.service;

import java.util.List;

import com.practice.spring.springcorexml.model.Customer;
import com.practice.spring.springcorexml.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl() {}
	//Constructor Injection
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	//Setter Injection
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	//Autowire By Name Or Type
	/*public void setFoo(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}*/
}
