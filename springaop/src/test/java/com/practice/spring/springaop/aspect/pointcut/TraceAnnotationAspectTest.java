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
import com.practice.spring.springaop.service.simple.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleServiceAspectConfiguration.class)
public class TraceAnnotationAspectTest {

	@Autowired
	TraceAnnotationAspect traceAnnotationAspect;
	
	@Autowired
	SimpleService simpleService;
	
	@Before
	public void setUp() {
		traceAnnotationAspect.resetCalled();
	}
	
	@Test
	public void tracingOnNotAnnotatedMethodIsNotCalled() {
		assertThat(traceAnnotationAspect.getCalled(), is(0));
		simpleService.doSomething();
		assertThat(traceAnnotationAspect.getCalled(), is(0));
	}
	
	@Test
	public void tracingOnAnnotatedMethodIsCalled() {
		assertThat(traceAnnotationAspect.getCalled(), is(0));
		simpleService.annotated();
		assertThat(traceAnnotationAspect.getCalled(), is(1));
	}
}
