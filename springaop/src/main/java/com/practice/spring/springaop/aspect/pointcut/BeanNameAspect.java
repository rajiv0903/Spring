package com.practice.spring.springaop.aspect.pointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeanNameAspect {

	Logger logger = LoggerFactory.getLogger(BeanNameAspect.class);

	private int called = 0;

	public void resetCalled() {
		called = 0;
	}

	public int getCalled() {
		return called;
	}

	//@Around("bean(*Service)") //Bean name matching with Service 
	//@Around("bean(*)") //Any Spring Bean Name
	@Around("com.practice.spring.springaop.aspect.pointcut.MyPointcuts.beanNamePointcut()")
	public Object trace(ProceedingJoinPoint proceedingJP) throws Throwable {
		String methodInformation = proceedingJP.getStaticPart().getSignature().toString();
		logger.info("Entering : " + methodInformation);

		called++;

		for (Object arg : proceedingJP.getArgs()) {
			logger.info("Arg : " + arg);
		}
		try {
			return proceedingJP.proceed();

		} catch (Throwable ex) {
			logger.error("Exception in : " + methodInformation, ex);
			throw ex;

		} finally {
			logger.info("Exiting : " + methodInformation);
		}
	}
}
