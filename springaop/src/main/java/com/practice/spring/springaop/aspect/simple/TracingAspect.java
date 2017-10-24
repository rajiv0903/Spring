package com.practice.spring.springaop.aspect.simple;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {
	
	Logger logger = LoggerFactory.getLogger(TracingAspect.class);
			
	boolean enteringCall;
	
	public boolean enteringCalled() {
		return enteringCall;
	}
	
//	@Before("execution(void doSomethingElse(int))")
	@Before("execution(* com..*Service.*(..))")
	public void entering(JoinPoint joinPoint) {
		enteringCall = true;
		logger.info("Entering : "+
				joinPoint.getStaticPart().getSignature().toString());
	}

}
