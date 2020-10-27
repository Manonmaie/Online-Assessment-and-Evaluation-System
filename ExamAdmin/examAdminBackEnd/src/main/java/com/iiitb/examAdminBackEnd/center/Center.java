package com.iiitb.examAdminBackEnd.center;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.examAdminBackEnd.batch.Batch;

@Entity
@Table(name = "ea_center")
public class Center {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int centerId;
	private String centerCode,centerName;
	private int centerCapacity;
	
	@OneToMany(mappedBy = "center")
	@JsonIgnore
	private List<Batch> batchList;
	
	public Center() {
	}
	public Center(int centerId, String centerCode, String centerName, int centerCapacity) {
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
	public List<Batch> getBatchList() {
		return batchList;
	}
	public void setBatchList(List<Batch> batchList) {
		this.batchList = batchList;
	}
}
