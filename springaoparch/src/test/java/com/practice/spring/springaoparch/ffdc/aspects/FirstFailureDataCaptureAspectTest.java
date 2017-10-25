package com.practice.spring.springaoparch.ffdc.aspects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.practice.spring.springaoparch.configuration.SystemConfiguration;
import com.practice.spring.springaoparch.ffdc.service.PlainService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class FirstFailureDataCaptureAspectTest {

	@Autowired
	FirstFailureDataCaptureAspect firstFailureDataCaptureAspect;
	
	@Autowired
	PlainService plainService;
	
	@Test(expected= RuntimeException.class)
	public void performanceIsCalledForRepositories() {
		plainService.doIt(42);
	}
}
