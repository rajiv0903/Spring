package com.practice.spring.springaoparch.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLoggingAspect extends CallTracker{

	Logger logger = LoggerFactory.getLogger(ExceptionLoggingAspect.class);
	
	@AfterThrowing(pointcut= ""
			+ "com.practice.spring.springaoparch.architecture.SystemArchitecture.Repository() || "
			+ "com.practice.spring.springaoparch.architecture.SystemArchitecture.Service() ", 
			throwing= "exe")
	public void logException(Exception exe) {
		trackCall();
		logger.error("Exception:", exe);
	}
}
