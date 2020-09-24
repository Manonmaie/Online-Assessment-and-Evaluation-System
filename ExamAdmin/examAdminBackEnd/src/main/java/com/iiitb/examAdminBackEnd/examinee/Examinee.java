package com.iiitb.examAdminBackEnd.examinee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ea_examinee")
public class Examinee {
	@Id
	private int examinee_id;
	private String examinee_code,examinee_name,examinee_password,examinee_branch,examinee_email,examinee_college;
	
	public Examinee() {
	}
	public Examinee(int examinee_id, String examinee_code, String examinee_name, String examinee_password,
			String examinee_branch, String examinee_email, String examinee_college) {
		super();
		this.examinee_id = examinee_id;
		this.examinee_code = examinee_code;
		this.examinee_name = examinee_name;
		this.examinee_password = examinee_password;
		this.examinee_branch = examinee_branch;
		this.examinee_email = examinee_email;
		this.examinee_college = examinee_college;
	}
	
	public int getExaminee_id() {
		return examinee_id;
	}
	public void setExaminee_id(int examinee_id) {
		this.examinee_id = examinee_id;
	}
	public String getExaminee_code() {
		return examinee_code;
	}
	public void setExaminee_code(String examinee_code) {
		this.examinee_code = examinee_code;
	}
	public String getExaminee_name() {
		return examinee_name;
	}
	public void setExaminee_name(String examinee_name) {
		this.examinee_name = examinee_name;
	}
	public String getExaminee_password() {
		return examinee_password;
	}
	public void setExaminee_password(String examinee_password) {
		this.examinee_password = examinee_password;
	}
	public String getExaminee_branch() {
		return examinee_branch;
	}
	public void setExaminee_branch(String examinee_branch) {
		this.examinee_branch = examinee_branch;
	}
	public String getExaminee_email() {
		return examinee_email;
	}
	public void setExaminee_email(String examinee_email) {
		this.examinee_email = examinee_email;
	}
	public String getExaminee_college() {
		return examinee_college;
	}
	public void setExaminee_college(String examinee_college) {
		this.examinee_college = examinee_college;
	}
}
