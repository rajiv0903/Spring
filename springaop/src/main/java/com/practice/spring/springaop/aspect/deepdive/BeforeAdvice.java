package com.practice.spring.springaop.aspect.deepdive;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAdvice {

	Logger logger = LoggerFactory.getLogger(BeforeAdvice.class);

	boolean beforeCall;

	public void reset() {
		beforeCall = false;
	}

	public boolean beforeCalled() {
		return beforeCall;
	}

	@Before("execution(* com..*Service.*(..))")
	public void entering(JoinPoint joinPoint) {
		beforeCall = true;
		logger.info("Entering : "+
				joinPoint.getStaticPart().getSignature().toString());
	}
}
