package com.iiitb.assessmentBackEnd.questionPaper;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AsQuestionPaper {
	
	@Id
	private int qpId;
	
	private enum qpStatusList { PENDING, RECEIVED, ERROR_SENDING };
	
	private String qpCode;
//	private int batch_course_id;
	private double maximumMarks;
	private int duration;
	
	public AsQuestionPaper() {
		
	}
	
	public AsQuestionPaper(int qpId, String qpCode, double maximumMarks, int duration) {
		super();
		this.qpId = qpId;
		this.qpCode = qpCode;
		this.maximumMarks = maximumMarks;
		this.duration = duration;
	}
	
	public int getQpId() {
		return qpId;
	}
	public void setQpId(int qpId) {
		this.qpId = qpId;
	}
	public String getQpCode() {
		return qpCode;
	}
	public void setQpCode(String qpCode) {
		this.qpCode = qpCode;
	}
	public double getMaximumMarks() {
		return maximumMarks;
	}
	public void setMaximumMarks(double maximumMarks) {
		this.maximumMarks = maximumMarks;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
//	public int getBatch_course_id() {
//		return batch_course_id;
//	}
//	public void setBatch_course_id(int batch_course_id) {
//		this.batch_course_id = batch_course_id;
//	}
}
