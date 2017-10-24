package com.practice.spring.springaop.repository.deepdive;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.practice.spring.springaop.aspect.configuration.SimpleServiceAspectConfiguration;
import com.practice.spring.springaop.aspect.deepdive.BeforeAdvice;
import com.practice.spring.springaop.service.simple.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleServiceAspectConfiguration.class)
public class BeforeAdviceTest {

	@Autowired
	BeforeAdvice beforeAdvice;
	
	@Autowired
	SimpleService simpleService;
	
	@Test
	public void aspectIsCalled() {
		assertFalse(beforeAdvice.beforeCalled());
		simpleService.doSomethingElse(42);
		assertTrue(beforeAdvice.beforeCalled());
	}
}
