package com.practice.spring.springaoparch.architecture;

import org.aspectj.lang.annotation.Pointcut;


public class SystemArchitecture {

	@Pointcut("execution(* com.practice.spring.springaoparch.repository.*.*(..))")
	public void Repository() {
		
	}
	@Pointcut("execution(* com.practice.spring.springaoparch.service.*.*(..))")
	public void Service() {
		
	}
	
/*	@Pointcut("execution(* (@org.springframework.stereotype.Repository *).*(..))")
	public void Repository() {
		
	}
	@Pointcut("execution(* (@org.springframework.stereotype.Service *).*(..))")
	public void Service() {
		
	}*/
}
