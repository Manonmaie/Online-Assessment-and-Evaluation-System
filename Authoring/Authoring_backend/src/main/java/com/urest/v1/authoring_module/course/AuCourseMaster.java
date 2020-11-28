package com.urest.v1.authoring_module.course;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuCourseMaster {
	@Id
	private int courseMasterId;
	private String courseCode,courseName;
	
	public AuCourseMaster() {
	}
	public AuCourseMaster(int courseMasterId, String courseCode, String courseName) {
		super();
		this.courseMasterId = courseMasterId;
		this.courseCode = courseCode;
		this.courseName = courseName;
	}
	
	public int getCourseMasterId() {
		return courseMasterId;
	}
	public void setCourseMasterId(int courseMasterId) {
		this.courseMasterId = courseMasterId;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}