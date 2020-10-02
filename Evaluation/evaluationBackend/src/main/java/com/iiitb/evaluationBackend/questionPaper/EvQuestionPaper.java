package com.iiitb.evaluationBackend.questionPaper;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EvQuestionPaper {
	
	@Id
	private int qpId;
	
	private String qpCode;
	private double maximumMarks;
	private int duration;
	
	public EvQuestionPaper() {
		
	}
	
	public EvQuestionPaper(int qpId, String qpCode, double maximumMarks, int duration) {
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
}
