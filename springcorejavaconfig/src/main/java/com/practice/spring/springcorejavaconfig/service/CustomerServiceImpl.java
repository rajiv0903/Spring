package com.practice.spring.springcorejavaconfig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.practice.spring.springcorejavaconfig.model.Customer;
import com.practice.spring.springcorejavaconfig.repository.CustomerRepository;

@Service("customerService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepositoryByType;
	
	public CustomerServiceImpl() {}
	
	//@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("We are using Constructor Injection");
		this.customerRepositoryByType = customerRepository;
	}
	
	public List<Customer> findAll(){
		return customerRepositoryByType.findAll();
	}
	
	//@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("We are using Setter Injection");
		this.customerRepositoryByType = customerRepository;
	}
	
}
