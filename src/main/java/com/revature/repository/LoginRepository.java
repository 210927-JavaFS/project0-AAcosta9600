package com.revature.repository;

import com.revature.models.CustomerInfo;
import com.revature.models.User;

public interface LoginRepository {
	public boolean newUsername(String username);
	public boolean newPassword(String password);
	public String getAdminLevel(String username);
	public User register(String username, String password);
	public CustomerInfo setUserInfo(String username, String firstName, String lastName, String phoneNumber,
			String birthDate);
}
