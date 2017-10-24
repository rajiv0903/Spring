package com.practice.spring.springcorexml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.spring.springcorexml.model.Customer;
import com.practice.spring.springcorexml.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	//Member Injection Demo
	//@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl() {}
	//Constructor Injection
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("We are using Constructor Injection");
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	//Setter Injection
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("We are using Setter Injection");
		this.customerRepository = customerRepository;
	}
	
}
