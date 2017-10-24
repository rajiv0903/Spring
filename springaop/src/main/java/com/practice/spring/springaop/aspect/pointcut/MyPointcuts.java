package com.practice.spring.springaop.aspect.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

	@Pointcut("bean(*Service)")
	public void beanNamePointcut() {
	}
	@Pointcut("execution(* *..*Service.*(..))")
	public void classNamePointcut() {
	}
	
	@Pointcut("execution(@com.practice.spring.springaop.aspect.annotation.TraceAnnotation * *..*Service.*(..))")
	public void annotationPointcut() {
	}
}
