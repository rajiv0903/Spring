package com.practice.spring.springaop.repository.deepdive;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.practice.spring.springaop.aspect.configuration.SimpleServiceAspectConfiguration;
import com.practice.spring.springaop.aspect.deepdive.AroundAdvice;
import com.practice.spring.springaop.service.simple.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleServiceAspectConfiguration.class)
public class AroundAdviceTest {

	@Autowired
	AroundAdvice aroundAdvice;
	
	@Autowired
	SimpleService simpleService;

	@Before
	public void setUp() {
		aroundAdvice.reset();
	}
	
	@Test
	public void arounfAdviceIsCalledForSimpleMethod() {
		
		assertFalse(aroundAdvice.called());
		simpleService.doSomethingElse(42);
		assertTrue(aroundAdvice.called());
	}

	@Test(expected= RuntimeException.class)
	public void arounfAdviceIsCalledIfExceptionIsThrown() {
		
		assertFalse(aroundAdvice.called());
		try {
			simpleService.throwsRuntimeException();
			
		} finally {
			assertTrue(aroundAdvice.called());
		}
	}
	
	@Test
	public void arounfAdviceIsCalledIfValueIsReturned() {
		
		assertFalse(aroundAdvice.called());
		assertThat(simpleService.returnsString(), equalTo("Hello! Rajiv"));
		assertTrue(aroundAdvice.called());
	}
}
