package com.iiitb.examAdminBackEnd.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="ea_user")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName, password, status;
	
	public User() {
	}
	public User(int userId, String userName, String password, String status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.status = status;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
