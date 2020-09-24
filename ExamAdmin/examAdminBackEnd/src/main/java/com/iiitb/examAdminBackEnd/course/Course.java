package com.iiitb.examAdminBackEnd.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ea_course_master")
public class Course {
	@Id
	private int course_master_id;
	private String course_code,course_name;
	
	public Course() {
	}
	public Course(int course_master_id, String course_code, String course_name) {
		super();
		this.course_master_id = course_master_id;
		this.course_code = course_code;
		this.course_name = course_name;
	}
	
	public int getCourse_master_id() {
		return course_master_id;
	}
	public void setCourse_master_id(int course_master_id) {
		this.course_master_id = course_master_id;
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
}
