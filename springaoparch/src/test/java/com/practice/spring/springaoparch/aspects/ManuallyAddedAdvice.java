package com.practice.spring.springaoparch.aspects;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.practice.spring.springaoparch.model.User;
import com.practice.spring.springaoparch.service.MyService;

public class ManuallyAddedAdvice {
	
	
	@Test
	public void addedAdviceIsCalled() {
		
		TracingAspect tracingAspect = new TracingAspect();
		MyService originalObject = new MyService();
		
		AspectJProxyFactory proxyFactory = new AspectJProxyFactory(originalObject);
		proxyFactory.addAspect(tracingAspect);
		
		MyService proxy = proxyFactory.<MyService> getProxy();
		
		/*doNothing()
			.when(proxy)
				.doIt(new User("Rajiv", "Chaudhuri"), 23);*/
		
		assertFalse(tracingAspect.called());
		proxy.doIt(new User("Rajiv", "Chaudhuri"), 23);
		assertTrue(tracingAspect.called());
		
	}

}
