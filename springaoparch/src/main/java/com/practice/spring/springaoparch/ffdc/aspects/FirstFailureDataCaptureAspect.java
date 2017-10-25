package com.practice.spring.springaoparch.ffdc.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FirstFailureDataCaptureAspect {
	
	private ThreadLocal<CallContext> callContext = new ThreadLocal<>();
	
	private CallContext getCallContext() {
		CallContext result = callContext.get();
		if(result == null) {
			callContext.set(new CallContext());
			result = callContext.get();
		}
		return result;
	}
	@AfterThrowing(value="execution(* com.practice.spring.springaoparch.ffdc.service.*.*(..))", 
			throwing= "ex")
	public void afterThrowing(Throwable ex) {
		getCallContext().afterThrowing(ex);
	}
	
	@Before("execution(* com.practice.spring.springaoparch.ffdc.service.*.*(..))")
	public void before(JoinPoint joinPoint) {
		getCallContext().before(joinPoint);
	}
	
	@AfterReturning(pointcut="execution(* com.practice.spring.springaoparch.ffdc.service.*.*(..))",
			returning="result")
	public void afterReturning(Object result) {
		getCallContext().afterReturning(result);
	}

}
