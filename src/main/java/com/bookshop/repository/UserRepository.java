package com.bookshop.repository;

import java.sql.Connection;

import com.bookshop.config.DbConfig;
import com.bookshop.model.User;

public class UserRepository {
	private final Connection connection;
	private static final String USER_TABLE = "user";

	public UserRepository() {
		connection = new DbConfig().getConnection();
	}

	public User login(String email, String password) {
		try {
			final String QUERY = """
					SELECT user_id as id, role FROM %s WHERE email = ? AND password = ?
					""".formatted(USER_TABLE);

			var preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			var resultSet = preparedStatement.executeQuery();
		
			
			if( resultSet.next()) {
				int id = resultSet.getInt("id");
				int role =  resultSet.getInt("role");
				
				return new User(id, null, null, null, null, null, role);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new User(-1, null, null, null, null, null, -1);
		
	}

	public void register(User user) {
		try {
			final String QUERY = """
					INSERT INTO %s (name, email, password, number, address) values (?, ?, ?, ?, ?)
					""".formatted(USER_TABLE);

			var preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, user.name());
			preparedStatement.setString(2, user.email());
			preparedStatement.setString(3, user.password());
			preparedStatement.setString(4, user.number());
			preparedStatement.setString(5, user.address());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean existByEmail(String email) {
		try {
			final String QUERY = """
					SELECT user_id FROM %s WHERE email = ?
					""".formatted(USER_TABLE);
			
			var preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, email);
			
			var resultSet = preparedStatement.executeQuery();
			return resultSet.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
