package com.revature.repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Account;
import com.revature.utils.ConnectionUtils;

public class ManagerRepositoryImpl implements ManagerRepository{

	public List<Account> findApprovalList() {
		try (Connection conn = ConnectionUtils.getConnection()) { 
			String sql = "SELECT * FROM accounts WHERE approval = false;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Account> list = new ArrayList<>();

			while (result.next()) {
				Account account = new Account();
				account.setAccountNumber(result.getInt("account_number"));
				account.setUsername(result.getString("username"));
				account.setCash(result.getInt("cash"));
				account.setApproval(result.getBoolean("approval"));

				list.add(account);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean approve(String account, boolean b) {
		try (Connection conn = ConnectionUtils.getConnection()) { 
			String sql = "UPDATE accounts SET approval = true WHERE account_number =?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, Integer.parseInt(account));

			statement.execute();
			return true;



		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean cancel(String account) {
		try (Connection conn = ConnectionUtils.getConnection()) { 
			String sql = "DELETE FROM accounts WHERE account_number =?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, Integer.parseInt(account));

			statement.execute();
			return true;



		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public int getCashByAccount(String account) {
		try (Connection conn = ConnectionUtils.getConnection()) { 
			String sql = "Select * FROM accounts WHERE account_number =?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, Integer.parseInt(account));

			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return result.getInt("cash");
			}
			



		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void update(String account, int balance) {
		try (Connection conn = ConnectionUtils.getConnection()) { 
			String sql = "UPDATE accounts SET cash=? WHERE account_number = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, balance);
			statement.setInt(2, Integer.parseInt(account));
			
			statement.execute();





		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;

	}

}
