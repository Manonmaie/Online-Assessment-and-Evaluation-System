package com.iiitb.assessmentBackEnd.rpack1;

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
import com.iiitb.assessmentBackEnd.rpack.Rpack;
import com.iiitb.assessmentBackEnd.rpack2.Rpack2;

@Entity
@Table(name = "rpack1")
public class Rpack1 {
	@Id 
	@Column(name = "rpack1_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rpack1_id;
	
	@ManyToOne
	@JoinColumn(name="rpack_header_id")
	private Rpack rpack_header;
	
	@Column(name = "qp_id")
	private int qp_id;
	
	@Column(name = "maximum_marks")
	private float  maximum_marks;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "batch_id")
	private int batch_id;
	
	@OneToMany(mappedBy = "rpack1")
	@JsonIgnore
	private List<Rpack2> rpack2List;
	
	public Rpack1() {
		super();
	}

	public Rpack1(int qp_id, float maximum_marks, int duration, int batch_id) {
		super();
		this.qp_id = qp_id;
		this.maximum_marks = maximum_marks;
		this.duration = duration;
		this.batch_id = batch_id;
	}

	public int getRpack1_id() {
		return rpack1_id;
	}

	public void setRpack1_id(int rpack1_id) {
		this.rpack1_id = rpack1_id;
	}

	public Rpack getRpack_header() {
		return rpack_header;
	}

	public void setRpack_header(Rpack rpack_header) {
		this.rpack_header = rpack_header;
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

	public void setMaximum_marks(float maximum_marks) {
		this.maximum_marks = maximum_marks;
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
}
