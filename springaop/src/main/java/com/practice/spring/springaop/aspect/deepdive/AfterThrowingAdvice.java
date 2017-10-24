package com.practice.spring.springaop.aspect.deepdive;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowingAdvice {

	Logger logger = LoggerFactory.getLogger(AfterThrowingAdvice.class);

	boolean afterThrowingCall;

	public void reset() {
		afterThrowingCall = false;
	}

	public boolean afterThrowingCalled() {
		return afterThrowingCall;
	}

	@AfterThrowing(pointcut = "execution(* com..*Service.*(..))", throwing = "ex")
	public void exiting(RuntimeException ex) {
		afterThrowingCall = true;
		logger.error("Exception : " + ex);
	}
}
