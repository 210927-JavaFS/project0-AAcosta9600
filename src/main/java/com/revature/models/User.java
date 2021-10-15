package com.revature.models;

public class User {
	private String username;
	private String password;
	private String admin_level;
	public User(String username, String password, String admin_level) {
		super();
		this.username = username;
		this.password = password;
		this.admin_level = admin_level;
	}
	public User() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdmin_level() {
		return admin_level;
	}
	public void setAdmin_level(String admin_level) {
		this.admin_level = admin_level;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin_level == null) ? 0 : admin_level.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (admin_level == null) {
			if (other.admin_level != null)
				return false;
		} else if (!admin_level.equals(other.admin_level))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", admin_level=" + admin_level + "]";
	}
	
	
}
