package com.practice.spring.springaoparch.repository;


import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.practice.spring.springaoparch.model.User;

@Repository
public class MyRepository {

	public void doIt(User user) {

	}
	
	public void doSomeJDBCStuff() throws SQLException{
		Connection connection = null;
		connection.close();
	}
}
