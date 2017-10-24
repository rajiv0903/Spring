package com.practice.spring.springaop.aspect.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages="com.practice.spring.springaop")
public class SimpleServiceAspectConfiguration {

}
