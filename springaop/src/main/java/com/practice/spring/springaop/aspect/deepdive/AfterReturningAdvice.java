package com.practice.spring.springaop.aspect.deepdive;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturningAdvice {

	Logger logger = LoggerFactory.getLogger(AfterReturningAdvice.class);

	boolean afterReturningCall;

	public void reset() {
		afterReturningCall = false;
	}

	public boolean afterReturningCalled() {
		return afterReturningCall;
	}

	@AfterReturning(pointcut = "execution(* com..*Service.*(..))", returning = "string")
	public void logResult(String string) {
		afterReturningCall = true;
		logger.info("Result : " + string);
	}
}
