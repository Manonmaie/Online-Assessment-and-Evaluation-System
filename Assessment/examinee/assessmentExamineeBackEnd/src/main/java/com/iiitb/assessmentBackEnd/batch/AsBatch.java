package com.iiitb.assessmentBackEnd.batch;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.center.AsCenter;
import com.iiitb.assessmentBackEnd.courseMaster.AsCourseMaster;
import com.iiitb.assessmentBackEnd.examineeBatch.AsExamineeBatch;

@Entity
public class AsBatch {
	
	@Id
	private int batchId;
	
	private String batchCode;
	private LocalDateTime batchStartTime, batchEndTime;
	private enum qpStatusList { PENDING, RECEIVED, ERROR_SENDING};
	private String qpStatus;
	
	@OneToMany(mappedBy="batch")
//	@JsonIgnore
	private List<AsExamineeBatch> asExamineeList;
	
	@ManyToOne
	@JoinColumn(name="center_id")
	private AsCenter asCenter;
	
	@ManyToOne
	@JoinColumn(name="course_master_id")
	private AsCourseMaster asCourseMaster;

	public AsBatch() {
		
	}
	
	public AsBatch(int batchId, String batchCode, LocalDateTime batchStartTime, LocalDateTime batchEndTime,
			String qpStatus) {
		super();
		this.batchId = batchId;
		this.batchCode = batchCode;
		this.batchStartTime = batchStartTime;
		this.batchEndTime = batchEndTime;
		this.qpStatus = qpStatus;
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
		return asExamineeList;
	}
	public void setAsExamineeList(List<AsExamineeBatch> asExamineeList) {
		this.asExamineeList = asExamineeList;
	}
	public AsCenter getAsCenter() {
		return asCenter;
	}
	public void setAsCenter(AsCenter asCenter) {
		this.asCenter = asCenter;
	}
	public AsCourseMaster getAsCourseMaster() {
		return asCourseMaster;
	}
	public void setAsCourseMaster(AsCourseMaster asCourseMaster) {
		this.asCourseMaster = asCourseMaster;
	}
}
