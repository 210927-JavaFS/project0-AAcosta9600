package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.CustomerInfo;
import com.revature.models.User;
import com.revature.utils.ConnectionUtils;

public class LoginRepositoryImpl implements LoginRepository{

	public boolean newUsername(String username) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT * FROM users WHERE username =?;";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, username);

			ResultSet result = statement.executeQuery();
			
			return result.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean newPassword(String password) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT * FROM users WHERE passcode =?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			char [] encryptedPassword = password.toCharArray();
			for(int i=0;i<encryptedPassword.length;i++) {
				encryptedPassword[i] +=3;
			}
			statement.setString(1, String.valueOf(encryptedPassword));

			ResultSet result = statement.executeQuery();
			return result.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getAdminLevel(String username) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT * FROM users WHERE username =?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, username);

			ResultSet result = statement.executeQuery();
			if(result.next())
				return result.getString("admin_level");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "wrong";
	}


	@Override
	public User register(String username, String password) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "INSERT INTO users (username, passcode, admin_level) VALUES (?,?,'customer');";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, username);
			statement.setString(2, password);
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setAdmin_level("customer");
			
			statement.execute();
			return user;


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public CustomerInfo setUserInfo(String username, String firstName, String lastName, String phoneNumber,
			String birthDate) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "INSERT INTO customer_info (username, first_name,last_name,phone_number,birth_date) VALUES (?,?,?,?,?);";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, username);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setInt(4, Integer.parseInt(phoneNumber));
			statement.setInt(5, Integer.parseInt(birthDate));
			statement.execute();
			CustomerInfo customerInfo = new CustomerInfo();
			customerInfo.setUsername(username);
			customerInfo.setFirstName(firstName);
			customerInfo.setLastName(lastName);
			customerInfo.setPhoneNumber(Integer.parseInt(phoneNumber));
			customerInfo.setBirthDate(Integer.parseInt(birthDate));
			return customerInfo;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
