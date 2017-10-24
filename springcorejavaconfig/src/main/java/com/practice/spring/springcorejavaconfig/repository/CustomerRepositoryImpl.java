package com.practice.spring.springcorejavaconfig.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.practice.spring.springcorejavaconfig.model.Customer;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {
	
	@Value("${dbUserName}")
	private String dbUserName;
	
	public List<Customer> findAll(){
		
		System.out.println(dbUserName);
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer1 = new Customer();
		customer1.setUserName("rchaudhuri");
		customer1.setFirstName("Rajiv");
		customer1.setLastName("Chaudhuri");
		
		Customer customer2 = new Customer();
		customer2.setUserName("tbode");
		customer2.setFirstName("Tithi");
		customer2.setLastName("Bose");
		
		customers.add(customer1);
		customers.add(customer2);
		
		return customers;
	}

}
