package com.iiitb.examAdminBackEnd.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ea_course_master")
public class Course {
	@Id
	private int courseMasterId;
	private String courseCode,courseName;
	
	public Course() {
	}
	public Course(int courseMasterId, String courseCode, String courseName) {
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
