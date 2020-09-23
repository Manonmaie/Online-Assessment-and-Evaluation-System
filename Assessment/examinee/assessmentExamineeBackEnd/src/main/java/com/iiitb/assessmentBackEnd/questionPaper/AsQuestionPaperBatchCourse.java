package com.iiitb.assessmentBackEnd.questionPaper;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AsQuestionPaperBatchCourse {
	
	@Id
	private int qpId;
	
	private enum qpStatusList { PENDING, RECEIVED, ERROR_SENDING };
	
	private String qpCode;
	private double maximumMarks;
	private int duration;
	private LocalDateTime batchStartTime;
	private LocalDateTime batchEndTime;
	private String courseName;
	private String qpStatus;
	
	public AsQuestionPaperBatchCourse() {
		
	}
	
	public AsQuestionPaperBatchCourse(int qpId, String qpCode, double maximumMarks, int duration, LocalDateTime batchStartTime,
			LocalDateTime batchEndTime, String courseName, String qpStatus) {
		super();
		this.qpId = qpId;
		this.qpCode = qpCode;
		this.maximumMarks = maximumMarks;
		this.duration = duration;
		this.batchStartTime = batchStartTime;
		this.batchEndTime = batchEndTime;
		this.courseName = courseName;
		this.qpStatus = qpStatus;
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
	public LocalDateTime getBatchStartTime() {
		return batchStartTime;
	}
	public void setBatchStartTime(LocalDateTime batchStartTime) {
		this.batchStartTime = batchStartTime;
	}
	public LocalDateTime getBatchEndTime() {
		return batchEndTime;
	}
	public void setBatchEndTime(LocalDateTime batchEndTime) {
		this.batchEndTime = batchEndTime;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getQpStatus() {
		return qpStatus;
	}
	public void setQpStatus(String qpStatus) {
		this.qpStatus = qpStatus;
	}
}
