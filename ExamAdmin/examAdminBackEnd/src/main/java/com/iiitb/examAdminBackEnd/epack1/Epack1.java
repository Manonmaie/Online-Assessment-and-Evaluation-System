package com.iiitb.examAdminBackEnd.epack1;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.examAdminBackEnd.epack.Epack;

@Entity
@Table(name = "epack1")
public class Epack1 {
	@Id 
	@Column(name = "epack1_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int epack1_id;
	
	@ManyToOne
	@JoinColumn(name="epack_header_id")
	private Epack epack_header;
	
	@Column(name = "qp_id")
	private int qp_id;
	
	@Column(name = "qp_code")
	private String qp_code;
	
	@Column(name = "maximum_marks")
	private float maximum_marks;
	
	@Column(name = "instruction_id")
	private int instruction_id;
	
	@Column(name = "instruction_code")
	private String instruction_code;
	
	@Column(name = "instruction_text")
	private String instruction_text;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "batch_id")
	private int batch_id;
	
	@Column(name = "batch_code")
	private String batch_code;
	
	@Column(name = "batch_start_time")
	private LocalDateTime batch_start_time;

	@Column(name = "batch_end_time")
	private LocalDateTime batch_end_time;
	
	@Column(name = "center_id")
	private int center_id;
	
	@Column(name = "centre_code")
	private String centre_code;
	
	@Column(name = "centre_name")
	private String centre_name;
	
	@Column(name = "examdrive_id")
	private int examdrive_id;
	
	@Column(name = "examdrive_code")
	private String examdrive_code;
	
	@Column(name = "examdrive_name")
	private String examdrive_name;
	
	@Column(name = "course_master_id")
	private int course_master_id;
	
	@Column(name = "course_code")
	private String course_code;
	
	@Column(name = "course_name")
	private String course_name;

	public Epack1() {
	}

	public Epack1(int qp_id, String qp_code, float maximum_marks, int instruction_id, String instruction_code,
			String instruction_text, int duration, int batch_id, String batch_code, LocalDateTime batch_start_time,
			LocalDateTime batch_end_time, int center_id, String centre_code, String centre_name, int examdrive_id,
			String examdrive_code, String examdrive_name, int course_master_id, String course_code,
			String course_name) {
		super();
		this.qp_id = qp_id;
		this.qp_code = qp_code;
		this.maximum_marks = maximum_marks;
		this.instruction_id = instruction_id;
		this.instruction_code = instruction_code;
		this.instruction_text = instruction_text;
		this.duration = duration;
		this.batch_id = batch_id;
		this.batch_code = batch_code;
		this.batch_start_time = batch_start_time;
		this.batch_end_time = batch_end_time;
		this.center_id = center_id;
		this.centre_code = centre_code;
		this.centre_name = centre_name;
		this.examdrive_id = examdrive_id;
		this.examdrive_code = examdrive_code;
		this.examdrive_name = examdrive_name;
		this.course_master_id = course_master_id;
		this.course_code = course_code;
		this.course_name = course_name;
	}

	public Epack1(int epack1_id, int qp_id, String qp_code, float maximum_marks, int instruction_id,
			String instruction_code, String instruction_text, int duration, int batch_id, String batch_code,
			LocalDateTime batch_start_time, LocalDateTime batch_end_time, int center_id, String centre_code,
			String centre_name, int examdrive_id, String examdrive_code, String examdrive_name, int course_master_id,
			String course_code, String course_name) {
		super();
		this.epack1_id = epack1_id;
		this.qp_id = qp_id;
		this.qp_code = qp_code;
		this.maximum_marks = maximum_marks;
		this.instruction_id = instruction_id;
		this.instruction_code = instruction_code;
		this.instruction_text = instruction_text;
		this.duration = duration;
		this.batch_id = batch_id;
		this.batch_code = batch_code;
		this.batch_start_time = batch_start_time;
		this.batch_end_time = batch_end_time;
		this.center_id = center_id;
		this.centre_code = centre_code;
		this.centre_name = centre_name;
		this.examdrive_id = examdrive_id;
		this.examdrive_code = examdrive_code;
		this.examdrive_name = examdrive_name;
		this.course_master_id = course_master_id;
		this.course_code = course_code;
		this.course_name = course_name;
	}

	public int getEpack1_id() {
		return epack1_id;
	}

	public void setEpack1_id(int epack1_id) {
		this.epack1_id = epack1_id;
	}

	public Epack getEpack_header() {
		return epack_header;
	}

	public void setEpack_header(Epack epack_header) {
		this.epack_header = epack_header;
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

	public float getMaximum_marks() {
		return maximum_marks;
	}

	public void setMaximum_marks(float maximum_marks) {
		this.maximum_marks = maximum_marks;
	}

	public int getInstruction_id() {
		return instruction_id;
	}

	public void setInstruction_id(int instruction_id) {
		this.instruction_id = instruction_id;
	}

	public String getInstruction_code() {
		return instruction_code;
	}

	public void setInstruction_code(String instruction_code) {
		this.instruction_code = instruction_code;
	}

	public String getInstruction_text() {
		return instruction_text;
	}

	public void setInstruction_text(String instruction_text) {
		this.instruction_text = instruction_text;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public String getbatch_code() {
		return batch_code;
	}

	public void setbatch_code(String batch_code) {
		this.batch_code = batch_code;
	}

	public LocalDateTime getBatch_start_time() {
		return batch_start_time;
	}

	public void setBatch_start_time(LocalDateTime batch_start_time) {
		this.batch_start_time = batch_start_time;
	}

	public LocalDateTime getBatch_end_time() {
		return batch_end_time;
	}

	public void setBatch_end_time(LocalDateTime batch_end_time) {
		this.batch_end_time = batch_end_time;
	}

	public int getCenter_id() {
		return center_id;
	}

	public void setCenter_id(int center_id) {
		this.center_id = center_id;
	}

	public String getCentre_code() {
		return centre_code;
	}

	public void setCentre_code(String centre_code) {
		this.centre_code = centre_code;
	}

	public String getCentre_name() {
		return centre_name;
	}

	public void setCentre_name(String centre_name) {
		this.centre_name = centre_name;
	}

	public int getExamdrive_id() {
		return examdrive_id;
	}

	public void setExamdrive_id(int examdrive_id) {
		this.examdrive_id = examdrive_id;
	}

	public String getExamdrive_code() {
		return examdrive_code;
	}

	public void setExamdrive_code(String examdrive_code) {
		this.examdrive_code = examdrive_code;
	}

	public String getExamdrive_name() {
		return examdrive_name;
	}

	public void setExamdrive_name(String examdrive_name) {
		this.examdrive_name = examdrive_name;
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
