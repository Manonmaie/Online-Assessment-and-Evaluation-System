package com.iiitb.examAdminBackEnd.course;

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
import com.iiitb.examAdminBackEnd.examdrive.Examdrive;

@Entity
@Table(name = "ea_course_master")
public class Course {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseMasterId;
	private String courseCode,courseName;
	
	@OneToMany(mappedBy = "course")
	@JsonIgnore
	private List<Examdrive> examdriveList;
	
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
	public List<Examdrive> getExamdriveList() {
		return examdriveList;
	}
	public void setExamdriveList(List<Examdrive> examdriveList) {
		this.examdriveList = examdriveList;
	}
}
