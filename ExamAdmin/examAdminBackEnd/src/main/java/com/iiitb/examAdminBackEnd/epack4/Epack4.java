package com.iiitb.examAdminBackEnd.epack4;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.examAdminBackEnd.epack1.Epack1;

@Entity
@Table(name = "epack4")
public class Epack4 {
	@Id 
	@Column(name = "epack4_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int epack4_id;
	
	@ManyToOne
	@JoinColumn(name="epack1_id")
	private Epack1 epack1;
	
	@Column(name = "batch_id")
	private int batch_id;
	
	@Column(name = "examinee_batch_id")
	private int examinee_batch_id;
	
	@Column(name = "examinee_id")
	private int examinee_id;
	
	@Column(name = "examinee_code")
	private String examinee_code;
	
	@Column(name = "examinee_name")
	private String examinee_name;
	
	@Column(name = "examinee_password")
	private String examinee_password;
	
	@Column(name = "examinee_branch")
	private String examinee_branch;
	
	@Column(name = "examinee_email")
	private String examinee_email;
	
	@Column(name = "examinee_college")
	private String examinee_college;

	public Epack4() {
		super();
	}

	public Epack4(int batch_id, int examinee_batch_id, int examinee_id, String examinee_code, String examinee_name,
			String examinee_password, String examinee_branch, String examinee_email, String examinee_college) {
		super();
		this.batch_id = batch_id;
		this.examinee_batch_id = examinee_batch_id;
		this.examinee_id = examinee_id;
		this.examinee_code = examinee_code;
		this.examinee_name = examinee_name;
		this.examinee_password = examinee_password;
		this.examinee_branch = examinee_branch;
		this.examinee_email = examinee_email;
		this.examinee_college = examinee_college;
	}

	public int getEpack4_id() {
		return epack4_id;
	}

	public void setEpack4_id(int epack4_id) {
		this.epack4_id = epack4_id;
	}

	public Epack1 getEpack1() {
		return epack1;
	}

	public void setEpack1(Epack1 epack1) {
		this.epack1 = epack1;
	}

	public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public int getExaminee_batch_id() {
		return examinee_batch_id;
	}

	public void setExaminee_batch_id(int examinee_batch_id) {
		this.examinee_batch_id = examinee_batch_id;
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
