package com.iiitb.assessmentBackEnd.examinee;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinTable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.examineeBatch.AsExamineeBatch;

@Entity
public class AsExaminee {
	@Id
	private int examineeId;
	private String examineeCode,examineeName,examineePassword,examineeBranch,examineeEmail,examineeCollege;
	
	@OneToMany(mappedBy="examinee")
//	@JsonIgnore
//	@JoinTable(
//			  name = "as_examinee_batch", 
//			  joinColumns = @JoinColumn(name = "examinee_id", referencedColumnName = "examineeId"), 
//			  inverseJoinColumns = @JoinColumn(name = "batch_id", referencedColumnName = "batchId"))
	private List<AsExamineeBatch> asExamineeBatchList;
	
	public AsExaminee() {
		
	}
	public AsExaminee(int examineeId, String examineeCode, String examineeName, String examineePassword,
			String examineeBranch, String examineeEmail, String examineeCollege) {
		super();
		this.examineeId = examineeId;
		this.examineeCode = examineeCode;
		this.examineeName = examineeName;
		this.examineePassword = examineePassword;
		this.examineeBranch = examineeBranch;
		this.examineeEmail = examineeEmail;
		this.examineeCollege = examineeCollege;
	}
	
	public int getExamineeId() {
		return examineeId;
	}
	public void setExamineeId(int examineeId) {
		this.examineeId = examineeId;
	}
	public String getExamineeCode() {
		return examineeCode;
	}
	public void setExamineeCode(String examineeCode) {
		this.examineeCode = examineeCode;
	}
	public String getExamineeName() {
		return examineeName;
	}
	public void setExamineeName(String examineeName) {
		this.examineeName = examineeName;
	}
	public String getExamineePassword() {
		return examineePassword;
	}
	public void setExamineePassword(String examineePassword) {
		this.examineePassword = examineePassword;
	}
	public String getExamineeBranch() {
		return examineeBranch;
	}
	public void setExamineeBranch(String examineeBranch) {
		this.examineeBranch = examineeBranch;
	}
	public String getExamineeEmail() {
		return examineeEmail;
	}
	public void setExamineeEmail(String examineeEmail) {
		this.examineeEmail = examineeEmail;
	}
	public String getExamineeCollege() {
		return examineeCollege;
	}
	public void setExamineeCollege(String examineeCollege) {
		this.examineeCollege = examineeCollege;
	}
	public List<AsExamineeBatch> getAsBatchList() {
		return asExamineeBatchList;
	}
	public void setAsBatchList(List<AsExamineeBatch> asBatchList) {
		this.asExamineeBatchList = asBatchList;
	}
}
