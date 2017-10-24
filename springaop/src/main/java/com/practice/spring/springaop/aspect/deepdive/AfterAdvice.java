package com.practice.spring.springaop.aspect.deepdive;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAdvice {

	Logger logger = LoggerFactory.getLogger(AfterAdvice.class);
	
	boolean afterCall;
	
	public void reset() {
		afterCall = false;
	}
	public boolean afterCalled() {
		return afterCall;
	}
	//Called even if method throw exception
	@After("execution(* com..*Service.*(..))")
	public void exiting(JoinPoint joinPoint) {
		afterCall = true;
		logger.info("Exiting : "+
				joinPoint.getStaticPart().getSignature().toString());
		for(Object arg: joinPoint.getArgs()) {
			logger.info("Arg : "+arg);
		}
	}
	
}
