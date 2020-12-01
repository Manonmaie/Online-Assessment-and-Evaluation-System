package com.iiitb.examAdminBackEnd.batch;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.examAdminBackEnd.center.Center;
import com.iiitb.examAdminBackEnd.examdrive.Examdrive;
import com.iiitb.examAdminBackEnd.examineeBatch.ExamineeBatchMarks;
import com.iiitb.examAdminBackEnd.questionPaper.QuestionPaper;

@Entity
@Table (name ="ea_batch")
public class Batch {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int batchId;
	private String batchCode,qpStatus;
	private LocalDateTime batchStartTime, batchEndTime;
	
	@ManyToOne
	@JoinColumn(name="center_id")
	private Center center;
	
	@ManyToOne
	@JoinColumn(name="examdrive_id")
//	@JsonIgnore
	private Examdrive examdrive;
	
	@OneToMany(mappedBy = "batch")
	@JsonIgnore
	private List<ExamineeBatchMarks> examineeBatchList;
	
	@OneToOne
	@JoinColumn(name="qp_id")
	@JsonIgnore
	private QuestionPaper qp;
	
	public Batch() {
	}
	public Batch(int batchId, String batchCode, String qpStatus, LocalDateTime batchStartTime,
			LocalDateTime batchEndTime) {
		super();
		this.batchId = batchId;
		this.batchCode = batchCode;
		this.qpStatus = qpStatus;
		this.batchStartTime = batchStartTime;
		this.batchEndTime = batchEndTime;
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
	public String getQpStatus() {
		return qpStatus;
	}
	public void setQpStatus(String qpStatus) {
		this.qpStatus = qpStatus;
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
	public Center getCenter() {
		return center;
	}
	public void setCenter(Center center) {
		this.center = center;
	}
	public Examdrive getExamdrive() {
		return examdrive;
	}
	public void setExamdrive(Examdrive examdrive) {
		this.examdrive = examdrive;
	}
	public List<ExamineeBatchMarks> getExamineeBatchList() {
		return examineeBatchList;
	}
	public void setExamineeBatchList(List<ExamineeBatchMarks> examineeBatchList) {
		this.examineeBatchList = examineeBatchList;
	}
	public QuestionPaper getQp() {
		return qp;
	}
	public void setQp(QuestionPaper qp) {
		this.qp = qp;
	}
}
