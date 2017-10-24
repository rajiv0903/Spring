package com.practice.spring.springaop.aspect.pointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TraceAnnotationAspect {

	Logger logger = LoggerFactory.getLogger(TraceAnnotationAspect.class);

	private int called = 0;

	public void resetCalled() {
		called = 0;
	}

	public int getCalled() {
		return called;
	}

	//@Around("execution(@com.practice.spring.springaop.aspect.annotation.TraceAnnotation * *..*Service.*(..))")
	@Around("com.practice.spring.springaop.aspect.pointcut.MyPointcuts.annotationPointcut()")
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
