package com.practice.spring.springaop.repository.deepdive;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.practice.spring.springaop.aspect.configuration.SimpleServiceAspectConfiguration;
import com.practice.spring.springaop.aspect.deepdive.AfterThrowingAdvice;
import com.practice.spring.springaop.service.simple.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleServiceAspectConfiguration.class)
public class AfterThrowingAdviceTest {

	@Autowired
	AfterThrowingAdvice afterThrowingAdvice;
	
	@Autowired
	SimpleService simpleService;

	@Before
	public void setUp() {
		afterThrowingAdvice.reset();
	}
	
	@Test
	public void afterThrowingIsNotCalledIfMethodReturnsSuccessfully() {
		
		assertFalse(afterThrowingAdvice.afterThrowingCalled());
		simpleService.doSomethingElse(42);
		assertFalse(afterThrowingAdvice.afterThrowingCalled());
	}

	@Test(expected= RuntimeException.class)
	public void afterThrowingIsCalledIfMethodThrowsRuntimeException() {
		
		assertFalse(afterThrowingAdvice.afterThrowingCalled());
		try {
			simpleService.throwsRuntimeException();
			
		} finally {
			assertTrue(afterThrowingAdvice.afterThrowingCalled());
		}
	}
	
	@Test(expected= RuntimeException.class)
	public void afterThrowingIsNotCalledIfMethodThrowsException() throws Exception{
		
		assertFalse(afterThrowingAdvice.afterThrowingCalled());
		try {
			simpleService.throwsException();
			
		} finally {
			assertFalse(afterThrowingAdvice.afterThrowingCalled());
		}
	}

}
