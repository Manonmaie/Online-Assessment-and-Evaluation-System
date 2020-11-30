package com.iiitb.assessmentBackEnd.examineeBatch;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.batch.AsBatch;
import com.iiitb.assessmentBackEnd.examinee.AsExaminee;

@Entity
public class AsExamineeBatch {
	
//	@Id
	@Column (name = "examinee_batch_id")
	private int examineeBatchIdPK;
	
	@EmbeddedId
    private ExamineeBatchKey examineeBatchId;
	
	private LocalDateTime examineeBatchStartTime, examineeBatchEndTime;
	private enum examineeBatchStatusList {NOT_STARTED, IN_PROGRESS, COMPLETED};
	private String examineeBatchStatus;
 
    @ManyToOne
    @MapsId("examineeId")
    @JoinColumn(name = "examinee_id")
    @JsonIgnore
    private AsExaminee examinee;
 
    @ManyToOne
    @MapsId("batchId")
    @JoinColumn(name = "batch_id")
    @JsonIgnore
    private AsBatch batch;

    public AsExamineeBatch() {
    	
    }
    
	public AsExamineeBatch(ExamineeBatchKey examineeBatchId, LocalDateTime examineeBatchStartTime, LocalDateTime examineeBatchEndTime, 
			String examineeBatchStatus, AsExaminee examinee, AsBatch batch, int examineeBatchIdPK) {
		super();
		this.examineeBatchId = examineeBatchId;
		this.examineeBatchStartTime = examineeBatchStartTime;
		this.examineeBatchEndTime = examineeBatchEndTime;
		this.examineeBatchStatus = examineeBatchStatus;
		this.examinee = examinee;
		this.batch = batch;
		this.examineeBatchIdPK = examineeBatchIdPK;
	}

	public ExamineeBatchKey getExamineeBatchId() {
		return examineeBatchId;
	}

	public void setExamineeBatchId(ExamineeBatchKey examineeBatchId) {
		this.examineeBatchId = examineeBatchId;
	}
	
	public LocalDateTime getExamineeBatchStartTime() {
		return examineeBatchStartTime;
	}

	public void setExamineeBatchStartTime(LocalDateTime examineeBatchStartTime) {
		this.examineeBatchStartTime = examineeBatchStartTime;
	}

	public LocalDateTime getExamineeBatchEndTime() {
		return examineeBatchEndTime;
	}

	public void setExamineeBatchEndTime(LocalDateTime examineeBatchEndTime) {
		this.examineeBatchEndTime = examineeBatchEndTime;
	}

	public String getExamineeBatchStatus() {
		return examineeBatchStatus;
	}

	public void setExamineeBatchStatus(String examineeBatchStatus) {
		this.examineeBatchStatus = examineeBatchStatus;
	}

	public AsExaminee getExaminee() {
		return examinee;
	}

	public void setExaminee(AsExaminee examinee) {
		this.examinee = examinee;
	}

	public AsBatch getBatch() {
		return batch;
	}

	public void setBatch(AsBatch batch) {
		this.batch = batch;
	}

	public int getExamineeBatchIdPK() {
		return examineeBatchIdPK;
	}

	public void setExamineeBatchIdPK(int examineeBatchIdPK) {
		this.examineeBatchIdPK = examineeBatchIdPK;
	}
	
}
