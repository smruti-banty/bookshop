package com.bookshop.service;

import com.bookshop.model.User;
import com.bookshop.repository.UserRepository;

public class UserService {
	private final UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public User login(String email, String password) {
		return userRepository.login(email, password);
	}
	
	public boolean register(User user) {
		boolean isUserExist = userRepository.existByEmail(user.email()); 	
		if(!isUserExist) {
			userRepository.register(user);
			return true;
		}
	
		return false;
	}
}
