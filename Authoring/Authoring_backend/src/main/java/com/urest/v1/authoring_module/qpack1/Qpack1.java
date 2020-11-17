package com.urest.v1.authoring_module.qpack1;

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
import com.urest.v1.authoring_module.qpack.Qpack;
//import com.urest.v1.authoring_module.qpack2.Qpack2;

@Entity
@Table(name = "qpack1")
public class Qpack1 {
	@Id 
	@Column(name = "qpack1_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qpack1_id;
	
	@ManyToOne
	@JoinColumn(name="qpack_header_id")
	private Qpack qpack_header;
	
	@Column(name = "qp_id")
	private int qp_id;
	
	@Column(name = "maximum_marks")
	private int maximum_marks;
	
	@Column(name = "instruction_id")
	private int instruction_id;
	
	@Column(name = "instruction_text")
	private String instruction_text;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "course_id")
	private int course_id;
	
	@Column(name = "course_code")
	private String course_code;
	
	@Column(name = "course_name")
	private String course_name;
	
	@Column(name = "batch_code")
	private String batch_code;
	
//	@OneToMany(mappedBy = "qpack1")
//	@JsonIgnore
//	private List<Qpack2> qpack2List;

	public Qpack1() {
	}

	public Qpack1(int qp_id, int maximum_marks, int instruction_id, String instruction_text, int duration,
			int course_id, String course_code, String course_name, String batch_code) {
		super();
		this.qp_id = qp_id;
		this.maximum_marks = maximum_marks;
		this.instruction_id = instruction_id;
		this.instruction_text = instruction_text;
		this.duration = duration;
		this.course_id = course_id;
		this.course_code = course_code;
		this.course_name = course_name;
		this.batch_code = batch_code;
	}


	public int getQpack1_id() {
		return qpack1_id;
	}

	public void setQpack1_id(int qpack1_id) {
		this.qpack1_id = qpack1_id;
	}

	public Qpack getQpack_header() {
		return qpack_header;
	}

	public void setQpack_header(Qpack qpack_header) {
		this.qpack_header = qpack_header;
	}

	public int getQp_id() {
		return qp_id;
	}

	public void setQp_id(int qp_id) {
		this.qp_id = qp_id;
	}

	public float getMaximum_marks() {
		return maximum_marks;
	}

	public void setMaximum_marks(int maximum_marks) {
		this.maximum_marks = maximum_marks;
	}


	public int getInstruction_id() {
		return instruction_id;
	}


	public void setInstruction_id(int instruction_id) {
		this.instruction_id = instruction_id;
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


	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
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


	public String getBatch_code() {
		return batch_code;
	}


	public void setBatch_code(String batch_code) {
		this.batch_code = batch_code;
	}


//	public List<Qpack2> getQpack2List() {
//		return qpack2List;
//	}


//	public void setQpack2List(List<Qpack2> qpack2List) {
//		this.qpack2List = qpack2List;
//	}
	
}
