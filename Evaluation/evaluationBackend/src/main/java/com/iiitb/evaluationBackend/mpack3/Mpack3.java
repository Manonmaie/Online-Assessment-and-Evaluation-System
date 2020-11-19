package com.iiitb.evaluationBackend.mpack3;

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
import com.iiitb.evaluationBackend.mpack2.Mpack2;
@Entity
@Table(name = "mpack3")
public class Mpack3 {
	@Id 
	@Column(name = "mpack3_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mpack3_id;
	
	@ManyToOne
	@JoinColumn(name="mpack2_id")
	private Mpack2 mpack2;
	
	@Column(name = "qp_id")
	private int qp_id;
	
	@Column(name = "examinee_batch_id")
	private int examinee_batch_id;
	
	@Column(name = "qp_item_id")
	private int qp_item_id;
	
	@Column(name = "examinee_item_marks")
	private float examinee_item_marks;

	public Mpack3() {
		super();
	}

	public Mpack3(int qp_id, int examinee_batch_id, int qp_item_id, float examinee_item_marks) {
		super();
		this.qp_id = qp_id;
		this.examinee_batch_id = examinee_batch_id;
		this.qp_item_id = qp_item_id;
		this.examinee_item_marks = examinee_item_marks;
	}

	public int getMpack3_id() {
		return mpack3_id;
	}

	public void setMpack3_id(int mpack3_id) {
		this.mpack3_id = mpack3_id;
	}

	public Mpack2 getMpack2() {
		return mpack2;
	}

	public void setMpack2(Mpack2 mpack2) {
		this.mpack2 = mpack2;
	}

	public int getQp_id() {
		return qp_id;
	}

	public void setQp_id(int qp_id) {
		this.qp_id = qp_id;
	}

	public int getExaminee_batch_id() {
		return examinee_batch_id;
	}

	public void setExaminee_batch_id(int examinee_batch_id) {
		this.examinee_batch_id = examinee_batch_id;
	}

	public int getQp_item_id() {
		return qp_item_id;
	}

	public void setQp_item_id(int qp_item_id) {
		this.qp_item_id = qp_item_id;
	}

	public float getExaminee_item_marks() {
		return examinee_item_marks;
	}

	public void setExaminee_item_marks(float examinee_item_marks) {
		this.examinee_item_marks = examinee_item_marks;
	}
}
