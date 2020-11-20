package com.iiitb.assessmentBackEnd.rpack4;

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
import com.iiitb.assessmentBackEnd.rpack2.Rpack2;

@Entity
@Table(name = "rpack4")
public class Rpack4 {
	@Id 
	@Column(name = "rpack4_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rpack4_id;
	
	@ManyToOne
	@JoinColumn(name="rpack2_id")
	private Rpack2 rpack2;
	
	@Column(name="qp_id")
	private int qp_id;

	@Column(name = "batch_id")
	private int batch_id;
	
	@Column(name = "examinee_batch_id")
	private int examinee_batch_id;
	
	@Column(name = "examinee_id")
	private int examinee_id;
	
	@Column(name = "qp_item_id")
	private int qp_item_id;

	@Column(name = "response_id")
	private int response_id;
	
	@Column(name = "response_text")
	private String response_text;

	public Rpack4() {
		super();
	}

	public Rpack4(int qp_id, int batch_id, int examinee_batch_id, int examinee_id, int qp_item_id, int response_id,
			String response_text) {
		super();
		this.qp_id = qp_id;
		this.batch_id = batch_id;
		this.examinee_batch_id = examinee_batch_id;
		this.examinee_id = examinee_id;
		this.qp_item_id = qp_item_id;
		this.response_id = response_id;
		this.response_text = response_text;
	}

	public int getRpack4_id() {
		return rpack4_id;
	}

	public void setRpack4_id(int rpack4_id) {
		this.rpack4_id = rpack4_id;
	}

	public Rpack2 getRpack2() {
		return rpack2;
	}

	public void setRpack2(Rpack2 rpack2) {
		this.rpack2 = rpack2;
	}

	public int getQp_id() {
		return qp_id;
	}

	public void setQp_id(int qp_id) {
		this.qp_id = qp_id;
	}

	public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public int getExaminee_batch_id() {
		return examinee_batch_id;
	}

	public void setExaminee_batch_id(int examinee_batch_id) {
		this.examinee_batch_id = examinee_batch_id;
	}

	public int getExaminee_id() {
		return examinee_id;
	}

	public void setExaminee_id(int examinee_id) {
		this.examinee_id = examinee_id;
	}

	public int getQp_item_id() {
		return qp_item_id;
	}

	public void setQp_item_id(int qp_item_id) {
		this.qp_item_id = qp_item_id;
	}

	public int getResponse_id() {
		return response_id;
	}

	public void setResponse_id(int response_id) {
		this.response_id = response_id;
	}

	public String getResponse_text() {
		return response_text;
	}

	public void setResponse_text(String response_text) {
		this.response_text = response_text;
	}
}
