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
import com.practice.spring.springaop.aspect.deepdive.AfterAdvice;
import com.practice.spring.springaop.service.simple.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleServiceAspectConfiguration.class)
public class AfterAdviceTest {

	@Autowired
	AfterAdvice afterAdvice;
	
	@Autowired
	SimpleService simpleService;

	@Before
	public void setUp() {
		afterAdvice.reset();
	}

	@Test
	public void afterAspectIsCalledIfMethodReturnsSuccessfully() {
		
		assertFalse(afterAdvice.afterCalled());
		simpleService.doSomethingElse(42);
		assertTrue(afterAdvice.afterCalled());
	}

	@Test(expected= RuntimeException.class)
	public void afterAspectIsCalledIfMethodThrowsException() {
		
		assertFalse(afterAdvice.afterCalled());
		try {
			simpleService.throwsRuntimeException();
			
		} finally {
			assertTrue(afterAdvice.afterCalled());
		}
	}
}
