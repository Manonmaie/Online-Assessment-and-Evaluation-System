package com.iiitb.examAdminBackEnd.examDrive;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ea_examdrive")
public class Examdrive {
	
	@Id
	private int examdrive_id;
	private String examdrive_code,examdrive_name;
//	private enum statusList{NOT_STARTED,IN_PROGRESS,COMPLETED};
//	private statusList status;
	private String status;
	
	public Examdrive() {
	}
	
	public Examdrive(int examdrive_id, String examdrive_code, String examdrive_name, String status) {
		super();
		this.examdrive_id = examdrive_id;
		this.examdrive_code = examdrive_code;
		this.examdrive_name = examdrive_name;
		this.status = status;
	}
	
	public int getExamdrive_id() {
		return examdrive_id;
	}
	public void setExamdrive_id(int examdrive_id) {
		this.examdrive_id = examdrive_id;
	}
	public String getExamdrive_code() {
		return examdrive_code;
	}
	public void setExamdrive_code(String examdrive_code) {
		this.examdrive_code = examdrive_code;
	}
	public String getExamdrive_name() {
		return examdrive_name;
	}
	public void setExamdrive_name(String examdrive_name) {
		this.examdrive_name = examdrive_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
