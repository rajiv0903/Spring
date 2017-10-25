package com.practice.spring.springaoparch.ffdc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.spring.springaoparch.ffdc.component.ErroneousComponent;

@Service
public class PlainService {

	@Autowired 
	ErroneousService erroneousService;
	
	@Autowired 
	ErroneousComponent erroneousComponent;
	
	public void doIt(int i) {
		erroneousService.returnInt();
		erroneousComponent.throwException();
	}
}
