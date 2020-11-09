package com.iiitb.assessmentBackEnd.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.userRole.AsUserRole;

@Entity
public class AsUser {
	
	@Id
	private int userId;
	private String userName;
	private String password;
	private enum statusList { ACTIVE, INACTIVE};
	private String status;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<AsUserRole> asUserRoleList;
	
	public AsUser() {
		
	}
	
	public AsUser(int userId, String userName, String password, String status) {
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
