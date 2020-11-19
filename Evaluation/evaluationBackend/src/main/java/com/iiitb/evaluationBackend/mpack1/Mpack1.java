package com.iiitb.evaluationBackend.mpack1;

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
import com.iiitb.evaluationBackend.mpack.Mpack;

@Entity
@Table(name = "mpack1")
public class Mpack1 {
	@Id 
	@Column(name = "mpack1_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mpack1_id;
	
	@ManyToOne
	@JoinColumn(name="mpack_header_id")
	private Mpack mpack_header;
	
	@Column(name = "qp_id")
	private int qp_id;
	
	@Column(name = "maximum_marks")
	private float maximum_marks;
	
	@Column(name = "duration")
	private int duration;

	public Mpack1() {
		super();
	}

	public Mpack1(int qp_id, float maximum_marks, int duration) {
		super();
		this.qp_id = qp_id;
		this.maximum_marks = maximum_marks;
		this.duration = duration;
	}

	public int getMpack1_id() {
		return mpack1_id;
	}

	public void setMpack1_id(int mpack1_id) {
		this.mpack1_id = mpack1_id;
	}

	public Mpack getMpack_header() {
		return mpack_header;
	}

	public void setMpack_header(Mpack mpack_header) {
		this.mpack_header = mpack_header;
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
}
