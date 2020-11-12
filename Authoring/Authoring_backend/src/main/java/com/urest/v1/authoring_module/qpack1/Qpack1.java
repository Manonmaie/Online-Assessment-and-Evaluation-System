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
import com.urest.v1.authoring_module.qpack2.Qpack2;

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
	private float maximum_marks;
	
	@OneToMany(mappedBy = "qpack1")
	@JsonIgnore
	private List<Qpack2> qpack2List;

	public Qpack1() {
	}


	public Qpack1(int qp_id, float maximum_marks) {
		super();
		this.qp_id = qp_id;
		this.maximum_marks = maximum_marks;
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

	public void setMaximum_marks(float maximum_marks) {
		this.maximum_marks = maximum_marks;
	}


	public List<Qpack2> getQpack2List() {
		return qpack2List;
	}


	public void setQpack2List(List<Qpack2> qpack2List) {
		this.qpack2List = qpack2List;
	}
	
}
