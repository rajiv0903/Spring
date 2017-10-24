package com.practice.spring.springaop.service.simple;

import org.springframework.stereotype.Service;

import com.practice.spring.springaop.aspect.annotation.TraceAnnotation;

@Service
public class SimpleService {

	public void doSomething() {		
	}
	
	public void doSomethingElse(int i) {		
	}
	public void throwsRuntimeException() {
		throw new RuntimeException("Runtime Exception Occured");
	}
	public void throwsException() throws Exception {
		throw new Exception("Exception Occured");
	}
	public int returnsInt() {
		return 22;
	}
	public String returnsStringAndThrowsRuntimeException() {
		throw new RuntimeException("Runtime Exception Occured");		
	}
	public String returnsString() {
		return "Hello! Rajiv";
	}
	@TraceAnnotation
	public void annotated() {
	}
}
