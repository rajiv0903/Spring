package com.practice.spring.springaop.aspect.deepdive;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAdvice {

	Logger logger = LoggerFactory.getLogger(AroundAdvice.class);

	boolean call;

	public void reset() {
		call = false;
	}

	public boolean called() {
		return call;
	}

	@Around("execution(* com..*Service.*(..))")
	public Object trace(ProceedingJoinPoint proceedingJP) throws Throwable{
		call = true;
		String methodInformation = proceedingJP.getStaticPart().getSignature().toString();
		logger.info("Entering : " + methodInformation);
		for(Object arg: proceedingJP.getArgs()) {
			logger.info("Arg : "+arg);
		}
		try {
			return proceedingJP.proceed();
			
		}catch(Throwable ex) {
			logger.error("Exception in : "+methodInformation, ex);
			throw ex;
			
		}finally {
			logger.info("Exiting : "+ methodInformation);
		}
	}
}
