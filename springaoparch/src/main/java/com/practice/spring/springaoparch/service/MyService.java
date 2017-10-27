package com.practice.spring.springaoparch.service;

import org.springframework.stereotype.Service;

import com.practice.spring.springaoparch.model.User;

@Service
public class MyService {

	public void doIt(User user, int i ) {
		System.out.println("hi");
	}
	
/*	private Connection connection;
	
	public void doSomeJDBCStuff() {
		try {
		connection.close();
		}
		catch(SQLException exe) {
			exe.printStackTrace();
		}
	}*/
}
