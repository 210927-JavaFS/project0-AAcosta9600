package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:postgresql://javafs-210927.csmrxzq1bxmv.us-east-2.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "password";
		return DriverManager.getConnection(url, username, password);
	}
}