package com.revature.service;

import com.revature.models.User;
import com.revature.repository.LoginRepository;
import com.revature.repository.LoginRepositoryImpl;

public class LoginService {
	private LoginRepository loginRepository = new LoginRepositoryImpl();
	
	public boolean checkUsername(String username) {
		return loginRepository.newUsername(username);
	}

	public boolean checkPassword(String password) {
		return loginRepository.newPassword(password);
		
	}

	public String checkAdminLevel(String username) {
		return loginRepository.getAdminLevel(username);
	}

	public User register(String username, String password) {
		return loginRepository.register(username, password);
		
	}
		
	
}
