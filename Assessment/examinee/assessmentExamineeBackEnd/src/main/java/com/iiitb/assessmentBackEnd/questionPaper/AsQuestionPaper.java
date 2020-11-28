package com.iiitb.assessmentBackEnd.questionPaper;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.iiitb.assessmentBackEnd.batch.AsBatch;

@Entity
public class AsQuestionPaper {
	
	@Id
	private int qpId;
	
	private enum qpStatusList { PENDING, RECEIVED, ERROR_SENDING };
	
//	private String qpCode;
	private double maximumMarks;
	private int duration;
	
	@OneToOne
	@JoinColumn(name="batch_id")
	private AsBatch asBatch;

	public AsQuestionPaper() {
		
	}
	
	public AsQuestionPaper(int qpId, double maximumMarks, int duration, int batchId) {
		super();
		this.qpId = qpId;
//		this.qpCode = qpCode;
		this.maximumMarks = maximumMarks;
		this.duration = duration;
		this.asBatch = new AsBatch();
		this.asBatch.setBatchId(batchId);
	}
	
	public int getQpId() {
		return qpId;
	}
	public void setQpId(int qpId) {
		this.qpId = qpId;
	}
//	public String getQpCode() {
//		return qpCode;
//	}
//	public void setQpCode(String qpCode) {
//		this.qpCode = qpCode;
//	}
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
	public AsBatch getAsBatch() {
		return asBatch;
	}
	public void setAsBatch(AsBatch asBatch) {
		this.asBatch = asBatch;
	}
}
