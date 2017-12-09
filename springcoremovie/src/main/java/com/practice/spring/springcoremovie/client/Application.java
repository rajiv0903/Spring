package com.practice.spring.springcoremovie.client;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.spring.springcoremovie.delegate.MovieWorldTicketManager;
import com.practice.spring.springcoremovie.exception.MovieWorldException;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("service1.xml");

			Properties prop = (Properties) appContext.getBean("myProperties");
			System.out.println(prop.getProperty("ticketClass"));

			MovieWorldTicketManager movieWorldTicketManager = appContext.getBean("movieWorldTicketManager",
					MovieWorldTicketManager.class);
			movieWorldTicketManager.reserveSeats("1",
					prop.getProperty("ticketClass"), "1", "2017-12-07", "4:30");
			
		} catch (MovieWorldException exe) {
			System.err.println(exe);
		}
	}

}
