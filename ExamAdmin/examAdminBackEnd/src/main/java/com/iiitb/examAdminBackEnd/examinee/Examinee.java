package com.iiitb.examAdminBackEnd.examinee;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.iiitb.examAdminBackEnd.examineeBatch.ExamineeBatch;

@Entity
@Table(name = "ea_examinee")
public class Examinee {
	@Id
	private int examineeId;
	private String examineeCode,examineeName,examineePassword,examineeBranch,examineeEmail,examineeCollege;
	
	@OneToMany(mappedBy = "examinee", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<ExamineeBatch> examineeBatchList;
	
	public Examinee() {
	}
	public Examinee(int examineeId, String examineeCode, String examineeName, String examineePassword,
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
	public List<ExamineeBatch> getExamineeBatchList() {
		return examineeBatchList;
	}
	public void setExamineeBatchList(List<ExamineeBatch> examineeBatchList) {
		this.examineeBatchList = examineeBatchList;
	}
}
