package com.practice.spring.springcorejavaconfig.repository;

import java.util.List;

import com.practice.spring.springcorejavaconfig.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}