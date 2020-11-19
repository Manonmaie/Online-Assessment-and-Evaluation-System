package com.iiitb.evaluationBackend.mpack2;

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
import com.iiitb.evaluationBackend.mpack1.Mpack1;
import com.iiitb.evaluationBackend.mpack3.Mpack3;

@Entity
@Table(name = "mpack2")
public class Mpack2 {
	@Id 
	@Column(name = "mpack2_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mpack2_id;
	
	@ManyToOne
	@JoinColumn(name="mpack1_id")
	private Mpack1 mpack1;
	
	@Column(name = "qp_id")
	private int qp_id;
	
	@Column(name = "qp_item_id")
	private int qp_item_id;

	@Column(name = "item_text")
	private String item_text;
	
	@Column(name = "item_marks")
	private float item_marks;
	
	@Column(name = "item_type")
	private String item_type;
	
	@OneToMany(mappedBy = "mpack2")
	@JsonIgnore
	private List<Mpack3> mpack3List;

	public Mpack2() {
		super();
	}

	public Mpack2(int qp_id, int qp_item_id, String item_text, float item_marks, String item_type) {
		super();
		this.qp_id = qp_id;
		this.qp_item_id = qp_item_id;
		this.item_text = item_text;
		this.item_marks = item_marks;
		this.item_type = item_type;
	}

	public int getMpack2_id() {
		return mpack2_id;
	}

	public void setMpack2_id(int mpack2_id) {
		this.mpack2_id = mpack2_id;
	}

	public Mpack1 getMpack1() {
		return mpack1;
	}

	public void setMpack1(Mpack1 mpack1) {
		this.mpack1 = mpack1;
	}

	public int getQp_id() {
		return qp_id;
	}

	public void setQp_id(int qp_id) {
		this.qp_id = qp_id;
	}

	public int getQp_item_id() {
		return qp_item_id;
	}

	public void setQp_item_id(int qp_item_id) {
		this.qp_item_id = qp_item_id;
	}

	public String getItem_text() {
		return item_text;
	}

	public void setItem_text(String item_text) {
		this.item_text = item_text;
	}

	public float getItem_marks() {
		return item_marks;
	}

	public void setItem_marks(float item_marks) {
		this.item_marks = item_marks;
	}

	public String getItem_type() {
		return item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
}
