package com.bookshop.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class DbConfig {
	private static Connection connection;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {

		try {
			var details = getDetails();
			
			var pool = new MysqlConnectionPoolDataSource();
			pool.setUrl(details.getProperty("database.url"));
			pool.setUser(details.getProperty("database.username"));
			pool.setPassword(details.getProperty("database.password"));
			
			connection = pool.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	private Properties getDetails() throws Exception {
		var configFile = new FileInputStream(getPath());
		var properties = new Properties();
		properties.load(configFile);
		
		return properties;
	}

	public String getPath() throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");

		fullPath = pathArr[0] + File.separator;
		return fullPath + "WEB-INF/resources/dbconfig.properties";

	}
}
