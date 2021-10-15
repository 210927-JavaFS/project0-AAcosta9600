package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
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

			statement.setString(1, password);

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


}
