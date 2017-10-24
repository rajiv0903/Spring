package com.practice.spring.springaop.aspect.pointcut;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.practice.spring.springaop.aspect.configuration.SimpleServiceAspectConfiguration;
import com.practice.spring.springaop.repository.simple.SimpleRepository;
import com.practice.spring.springaop.service.simple.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleServiceAspectConfiguration.class)
public class BeanNameAspectTest {

	@Autowired
	BeanNameAspect beanNameAspect;
	
	@Autowired
	SimpleService simpleService;
	
	@Autowired
	SimpleRepository simpleRepository;

	@Before
	public void setUp() {
		beanNameAspect.resetCalled();
	}
	
	@Test
	public void tracingOnServiceIscalled() {
		assertThat(beanNameAspect.getCalled(), is(0));
		simpleService.doSomething();
		assertThat(beanNameAspect.getCalled(), is(1));
	}
	
	@Test
	public void tracingOnRepositoryIsNotCalled() {
		assertThat(beanNameAspect.getCalled(), is(0));
		simpleRepository.doSomething();
		assertThat(beanNameAspect.getCalled(), is(0));
	}
}
