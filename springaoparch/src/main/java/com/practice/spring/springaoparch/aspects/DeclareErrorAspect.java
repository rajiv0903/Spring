package com.practice.spring.springaoparch.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareError;

@Aspect
public class DeclareErrorAspect {

	@DeclareError(
			" (call (* java.sql..*.*(..)) || "
			+ " call (* javax.sql..*.*(..)) ) "
			+ " && !within(com.practice.spring.springaoparch.repository..*) "
			)
	public static final String jdbcOnlyInRepository
		="JDBC may only be used in Repository!";
	
	@DeclareError(
			"call (* java.lang.Exception+.printStackTrace(..)) "
			)
	public static final String noPrintStackTrace
		="No printStackTrace() - log exception please!";
}
