package com.policyapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static Connection connection=null;
	public static Connection  openConnection() {
		String url="jdbc:mysql://localhost:3306/policydb ";
		String username="root";
		String password="root";
		try {
		connection =DriverManager.getConnection(url,username,password);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
