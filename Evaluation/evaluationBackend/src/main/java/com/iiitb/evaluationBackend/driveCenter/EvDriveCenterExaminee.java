package com.iiitb.evaluationBackend.driveCenter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EvDriveCenterExaminee {
	
	@Id
	private int drive_center_examinee_id;
	private String status;
	public EvDriveCenterExaminee() {
	
		
	}
	public EvDriveCenterExaminee(int drive_id,String status) {
		this.drive_center_examinee_id = drive_id;
		this.setStatus_id(status);
	}
	
	public int getDrive_center_examinee_id() {
		return drive_center_examinee_id;
	}

	public void setDrive_center_examinee_id(int drive_center_examinee_id) {
		this.drive_center_examinee_id = drive_center_examinee_id;
	}
	public String getStatus_id() {
		return status;
	}
	public void setStatus_id(String status) {
		this.status = status;
	}
	
}
