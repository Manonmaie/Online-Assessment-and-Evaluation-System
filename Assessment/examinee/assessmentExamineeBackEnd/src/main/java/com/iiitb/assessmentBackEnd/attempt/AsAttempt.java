package com.iiitb.assessmentBackEnd.attempt;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import com.iiitb.assessmentBackEnd.examineeBatch.AsExamineeBatch;

@Entity
public class AsAttempt {
	
	@Id
	private int attemptId;
	
	private int attemptNumber;
	private LocalDateTime attemptStartTime, attemptEndTime;
	private enum attemptStatusList {IN_PROGRESS, COMPLETED, ABANDONED};
	private String attemptStatus;
	
	@ManyToOne
	@JoinColumns({
		 @JoinColumn(name = "batch_id", referencedColumnName="batch_id"),
		  @JoinColumn(name = "examinee_id", referencedColumnName="examinee_id")
		})
	private AsExamineeBatch asExamineeBatch;
	
//	@JoinColumn(name="examinee_batch_id")
//	@JoinTable(
//			  name = "as_examinee_batch", 
//			  joinColumns = @JoinColumn(name = "examinee_id", referencedColumnName = "examineeId"), 
//			  inverseJoinColumns = @JoinColumn(name = "batch_id", referencedColumnName = "batchId"))
	

	public AsAttempt() {
		
	}
	
	public AsAttempt(int attemptId, int attemptNumber, LocalDateTime attemptStartTime,
			LocalDateTime attemptEndTime, String attemptStatus, AsExamineeBatch asExamineeBatch) {
		super();
		this.attemptId = attemptId;
		this.attemptNumber = attemptNumber;
		this.attemptStartTime = attemptStartTime;
		this.attemptEndTime = attemptEndTime;
		this.attemptStatus = attemptStatus;
		this.asExamineeBatch = asExamineeBatch;
	}

	public int getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(int attemptId) {
		this.attemptId = attemptId;
	}

	public int getAttemptNumber() {
		return attemptNumber;
	}

	public void setAttemptNumber(int attemptNumber) {
		this.attemptNumber = attemptNumber;
	}

	public LocalDateTime getAttemptStartTime() {
		return attemptStartTime;
	}

	public void setAttemptStartTime(LocalDateTime attemptStartTime) {
		this.attemptStartTime = attemptStartTime;
	}

	public LocalDateTime getAttemptEndTime() {
		return attemptEndTime;
	}

	public void setAttemptEndTime(LocalDateTime attemptEndTime) {
		this.attemptEndTime = attemptEndTime;
	}

	public String getAttemptStatus() {
		return attemptStatus;
	}

	public void setAttemptStatus(String attemptStatus) {
		this.attemptStatus = attemptStatus;
	}

	public AsExamineeBatch getAsExamineeBatch() {
		return asExamineeBatch;
	}

	public void setAsExamineeBatch(AsExamineeBatch asExamineeBatch) {
		this.asExamineeBatch = asExamineeBatch;
	}
}
