package com.practice.spring.springaoparch.ffdc.service;

import org.springframework.stereotype.Service;

@Service
public class ErroneousService {

	
	public void throwException() {
		throw new RuntimeException();
	}
	
	public int returnInt() {
		return 42;
	}
}
