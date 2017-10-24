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
public class PerformanceAspectTest {

	@Autowired
	PerformanceAspect performanceAspect;

	@Autowired
	MyService myService;

	@Autowired
	MyRepository myRepository;

	User user;
	
	@Before
	public void setUp() {
		performanceAspect.resetCall();
		user = new User("Rajiv", "Chaudhuri");
	}

	@Test
	public void performanceIsCalledForRepositories() {
		assertFalse(performanceAspect.called());
		myRepository.doIt(user);
		assertTrue(performanceAspect.called());
	}

	@Test
	public void performanceIsNotCalledForServices() {
		assertFalse(performanceAspect.called());
		myService.doIt(user, 23);
		assertFalse(performanceAspect.called());
	}
}
