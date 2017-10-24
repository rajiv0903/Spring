package com.practice.spring.springaoparch.aspects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.practice.spring.springaoparch.configuration.SystemConfiguration;
import com.practice.spring.springaoparch.model.User;
import com.practice.spring.springaoparch.repository.MyRepository;
import com.practice.spring.springaoparch.service.MyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class AroundTracingAspectTest {

	@Autowired
	TracingAspect tracingAspect;

	@Autowired
	MyService myService;

	@Autowired
	MyRepository myRepository;
	
	User user;

	@Before
	public void setUp() {
		tracingAspect.resetCall();
		user = new User("Rajiv", "Chaudhuri");
	}

	@Test
	public void tracingIsCalledForRepositories() {
		assertFalse(tracingAspect.called());
		myRepository.doIt(user);
		assertTrue(tracingAspect.called());
	}

	@Test
	public void tracingIsCalledForServices() {
		assertFalse(tracingAspect.called());
		myService.doIt(user, 42);
		assertTrue(tracingAspect.called());
	}
}
