package com.iiitb.assessmentBackEnd.questionPaper;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AsQuestionPaper {
	
	@Id
	private int qp_id;
	
	private String qp_code;
	private int batch_course_id;
	private double maximum_marks;
	private int duration;
	
	public AsQuestionPaper() {
		
	}
	
	public AsQuestionPaper(int qp_id, String qp_code, int batch_course_id, double maximum_marks, int duration) {
		super();
		this.qp_id = qp_id;
		this.qp_code = qp_code;
		this.batch_course_id = batch_course_id;
		this.maximum_marks = maximum_marks;
		this.duration = duration;
	}
	
	public int getQp_id() {
		return qp_id;
	}
	public void setQp_id(int qp_id) {
		this.qp_id = qp_id;
	}
	public String getQp_code() {
		return qp_code;
	}
	public void setQp_code(String qp_code) {
		this.qp_code = qp_code;
	}
	public int getBatch_course_id() {
		return batch_course_id;
	}
	public void setBatch_course_id(int batch_course_id) {
		this.batch_course_id = batch_course_id;
	}
	public double getMaximum_marks() {
		return maximum_marks;
	}
	public void setMaximum_marks(double maximum_marks) {
		this.maximum_marks = maximum_marks;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
