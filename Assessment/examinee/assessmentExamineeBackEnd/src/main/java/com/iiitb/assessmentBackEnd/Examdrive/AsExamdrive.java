package com.iiitb.assessmentBackEnd.Examdrive;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.iiitb.assessmentBackEnd.courseMaster.AsCourseMaster;

@Entity
public class AsExamdrive {
	
	@Id
	private int examdriveId;
	private String examdriveCode,examdriveName;
	private enum statusList{NOT_STARTED,IN_PROGRESS,COMPLETED};
	private String status;
	
	@ManyToOne
	@JoinColumn(name="course_master_id")
	private AsCourseMaster asCourseMaster;
	
	public AsExamdrive() {
	}
	
	public AsExamdrive(int examdriveId, String examdriveCode, String examdriveName, String status, int course_master_id) {
		super();
		this.examdriveId = examdriveId;
		this.examdriveCode = examdriveCode;
		this.examdriveName = examdriveName;
		this.status = status;
		this.asCourseMaster = new AsCourseMaster();
		this.asCourseMaster.setCourseMasterId(course_master_id);
	}
	
	public int getExamdriveId() {
		return examdriveId;
	}
	public void setExamdriveId(int examdriveId) {
		this.examdriveId = examdriveId;
	}
	public String getExamdriveCode() {
		return examdriveCode;
	}
	public void setExamdriveCode(String examdriveCode) {
		this.examdriveCode = examdriveCode;
	}
	public String getExamdriveName() {
		return examdriveName;
	}
	public void setExamdriveName(String examdriveName) {
		this.examdriveName = examdriveName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public AsCourseMaster getCourseMaster() {
		return asCourseMaster;
	}

	public void setCourseMaster(AsCourseMaster course) {
		this.asCourseMaster = course;
	}
}