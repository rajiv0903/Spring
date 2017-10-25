package com.practice.spring.springaoparch.ffdc.component;

import org.springframework.stereotype.Component;

@Component
public class ErroneousComponent {

	public void throwException() {
		throw new RuntimeException();
		
	}

	
}
