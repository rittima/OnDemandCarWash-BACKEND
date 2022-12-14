package com.green.car.wash.company.admin.model;

public class AuthenticationRequest
{
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "AuthenticationRequest [userName=" + username + ", password=" + password + "]";
	}
	public AuthenticationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	
	

}
