package com.practice.spring.springaoparch.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect extends CallTracker{

	Logger logger = LoggerFactory.getLogger(TracingAspect.class);
	
	@Around("com.practice.spring.springaoparch.architecture.SystemArchitecture.Repository() || "
			+ " com.practice.spring.springaoparch.architecture.SystemArchitecture.Service() ")
	public void trace(ProceedingJoinPoint proceedingJP) throws Throwable{
		
		String methodInformation = proceedingJP.getStaticPart().getSignature().toString();
		logger.info("Entering : "+ methodInformation);
		trackCall();
		
		for (Object arg: proceedingJP.getArgs()) {
			logger.info("Arg : "+ arg);
		}
		try {
			proceedingJP.proceed();
			
		}catch(Throwable ex) {
			logger.error("Exception in : "+ methodInformation, ex);
			throw ex;
			
		}finally {
			logger.info("Exiting : "+ methodInformation);
		}
	}
}
