package com.green.car.wash.company.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User 
{
	@Id
	private int id;
	private String username;
	private String password;
	private boolean active;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isActive() {
		return active;
	}
	public User(int id, String username, String password, boolean active, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.active = active;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Userentity [id=" + id + ", userName=" + username + ", password=" + password + ", active=" + active
				+ ", role=" + role + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
