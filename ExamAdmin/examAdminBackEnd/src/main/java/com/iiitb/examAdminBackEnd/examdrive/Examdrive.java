package com.iiitb.examAdminBackEnd.examdrive;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.examAdminBackEnd.batch.Batch;
import com.iiitb.examAdminBackEnd.course.Course;

@Entity
@Table(name = "ea_examdrive")
public class Examdrive {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int examdriveId;
	private String examdriveCode,examdriveName;
//	private int courseMasterId;
//	private enum statusList{NOT_STARTED,IN_PROGRESS,COMPLETED};
//	private statusList status;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="course_master_id")
	private Course course;
	
	@OneToMany(mappedBy = "examdrive")
	@JsonIgnore
	private List<Batch> batchList;
	
	public Examdrive() {
	}
	
	public Examdrive(int examdriveId, String examdriveCode, String examdriveName, String status, int course_master_id) {
		super();
		this.examdriveId = examdriveId;
		this.examdriveCode = examdriveCode;
		this.examdriveName = examdriveName;
		this.status = status;
		this.course = new Course();
		this.course.setCourseMasterId(course_master_id);
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Batch> getBatchList() {
		return batchList;
	}

	public void setBatchList(List<Batch> batchList) {
		this.batchList = batchList;
	}
}
