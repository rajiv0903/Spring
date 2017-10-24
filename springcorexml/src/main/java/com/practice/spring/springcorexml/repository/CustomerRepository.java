package com.practice.spring.springcorexml.repository;

import java.util.List;

import com.practice.spring.springcorexml.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}