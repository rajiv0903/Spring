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
import com.practice.spring.springaop.aspect.deepdive.AfterReturningAdvice;
import com.practice.spring.springaop.service.simple.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleServiceAspectConfiguration.class)
public class AfterReturningAdviceTest {

	@Autowired
	AfterReturningAdvice afterReturningAdvice;

	@Autowired
	SimpleService simpleService;

	@Before
	public void setUp() {
		afterReturningAdvice.reset();
	}

	@Test
	public void afterReturningIsNotCalledIfReturnTypeDoesNotMatch() {

		assertFalse(afterReturningAdvice.afterReturningCalled());
		simpleService.returnsInt();
		assertFalse(afterReturningAdvice.afterReturningCalled());
	}

	@Test(expected= RuntimeException.class)
	public void afterReturningIsNotCalledIfExceptionIsThrown() {

		assertFalse(afterReturningAdvice.afterReturningCalled());
		try {
			simpleService.returnsStringAndThrowsRuntimeException();
		} finally {
			assertFalse(afterReturningAdvice.afterReturningCalled());
		}
	}
	
	@Test
	public void afterReturningIsNotCalledIfReturnTypeMatches() {

		assertFalse(afterReturningAdvice.afterReturningCalled());
		simpleService.returnsString();
		assertTrue(afterReturningAdvice.afterReturningCalled());
	}

}
