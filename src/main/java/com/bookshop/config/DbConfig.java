package com.bookshop.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConfig {
	private static Connection connection;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private DbConfig() {
	}

	public static Connection getConnection() {

		try {
			if (connection == null) {
				connection = DriverManager.getConnection("jdbc:mysql://localhost/bookshop", "root", "smruti");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
