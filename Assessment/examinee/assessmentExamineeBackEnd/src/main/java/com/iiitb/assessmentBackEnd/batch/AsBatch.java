package com.iiitb.assessmentBackEnd.batch;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.center.AsCenter;
import com.iiitb.assessmentBackEnd.courseMaster.AsCourseMaster;
import com.iiitb.assessmentBackEnd.examdrive.AsExamdrive;
import com.iiitb.assessmentBackEnd.examineeBatch.AsExamineeBatch;
import com.iiitb.assessmentBackEnd.questionPaper.AsQuestionPaper;

@Entity
public class AsBatch {
	
	@Id
	private int batchId;
	
	private String batchCode;
	private LocalDateTime batchStartTime, batchEndTime;
	private enum qpStatusList { PENDING, RECEIVED, ERROR_SENDING, SENT};
	private String qpStatus;
	
	@OneToMany(mappedBy="batch")
//	@JsonIgnore
	private List<AsExamineeBatch> asExamineeBatchList;
	
	@ManyToOne
	@JoinColumn(name="center_id")
	@JsonIgnore
	private AsCenter asCenter;
	
	@ManyToOne
	@JoinColumn(name="examdrive_id")
	private AsExamdrive asExamdrive;
	
//	@ManyToOne
//	@JoinColumn(name="course_master_id")
//	private AsCourseMaster asCourseMaster;
	
	@OneToOne
	@JoinColumn(name="qp_id")
	@JsonIgnore
	private AsQuestionPaper asQuestionPaper;

	public AsBatch() {
		
	}
	
	public AsBatch(int batchId, String batchCode, LocalDateTime batchStartTime, LocalDateTime batchEndTime,
			String qpStatus, int centerId, int examdriveId, int qpId) {
		super();
		this.batchId = batchId;
		this.batchCode = batchCode;
		this.batchStartTime = batchStartTime;
		this.batchEndTime = batchEndTime;
		this.qpStatus = qpStatus;
		this.asCenter = new AsCenter();
		this.asCenter.setCenterId(centerId);
		this.asExamdrive = new AsExamdrive();
		this.asExamdrive.setExamdriveId(examdriveId);
		this.asQuestionPaper = new AsQuestionPaper();
		this.asQuestionPaper.setQpId(qpId);
	}
	
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
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
	public String getQpStatus() {
		return qpStatus;
	}
	public void setQpStatus(String qpStatus) {
		this.qpStatus = qpStatus;
	}
	public List<AsExamineeBatch> getAsExamineeList() {
		return asExamineeBatchList;
	}
	public void setAsExamineeList(List<AsExamineeBatch> asExamineeList) {
		this.asExamineeBatchList = asExamineeList;
	}
	public AsCenter getAsCenter() {
		return asCenter;
	}
	public void setAsCenter(AsCenter asCenter) {
		this.asCenter = asCenter;
	}

	public AsExamdrive getAsExamdrive() {
		return asExamdrive;
	}

	public void setAsExamdrive(AsExamdrive asExamdrive) {
		this.asExamdrive = asExamdrive;
	}

	public AsQuestionPaper getAsQuestionPaper() {
		return asQuestionPaper;
	}

	public void setAsQuestionPaper(AsQuestionPaper asQuestionPaper) {
		this.asQuestionPaper = asQuestionPaper;
	}
//	public AsCourseMaster getAsCourseMaster() {
//		return asCourseMaster;
//	}
//	public void setAsCourseMaster(AsCourseMaster asCourseMaster) {
//		this.asCourseMaster = asCourseMaster;
//	}
}
