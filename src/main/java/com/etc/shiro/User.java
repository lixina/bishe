package com.etc.shiro;

public class User {
	private String username;
	private String userpwd;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public User(String username, String userpwd) {
		super();
		this.username = username;
		this.userpwd = userpwd;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
}
