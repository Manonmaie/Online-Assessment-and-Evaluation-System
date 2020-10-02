package com.iiitb.assessmentBackEnd.center;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AsCenter {
	
	@Id
	private int centerId;
	private String centerCode,centerName;
	private int centerCapacity;
	
	public AsCenter() {
	}
	public AsCenter(int centerId, String centerCode, String centerName, int centerCapacity) {
		super();
		this.centerId = centerId;
		this.centerCode = centerCode;
		this.centerName = centerName;
		this.centerCapacity = centerCapacity;
	}
	
	public int getCenterId() {
		return centerId;
	}
	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}
	public String getCenterCode() {
		return centerCode;
	}
	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public int getCenterCapacity() {
		return centerCapacity;
	}
	public void setCenterCapacity(int centerCapacity) {
		this.centerCapacity = centerCapacity;
	}
}