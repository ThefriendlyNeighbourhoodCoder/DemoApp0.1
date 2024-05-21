package com.userDetails.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	private static Connection con = null;
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false", "root","123456789");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return con;
		
	}
}
