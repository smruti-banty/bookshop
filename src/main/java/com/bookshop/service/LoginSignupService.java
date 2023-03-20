package com.bookshop.service;

import com.bookshop.model.User;
import com.bookshop.repository.LoginSignupRepository;

public class LoginSignupService {
	private final LoginSignupRepository loginSignupRepository;

	public LoginSignupService() {
		loginSignupRepository = new LoginSignupRepository();
	}

	public User login(String email, String password) {
		return loginSignupRepository.login(email, password);
	}
	
	public boolean register(User user) {
		boolean isUserExist = loginSignupRepository.existByEmail(user.email()); 	
		if(!isUserExist) {
			loginSignupRepository.register(user);
			return true;
		}
	
		return false;
	}
}
