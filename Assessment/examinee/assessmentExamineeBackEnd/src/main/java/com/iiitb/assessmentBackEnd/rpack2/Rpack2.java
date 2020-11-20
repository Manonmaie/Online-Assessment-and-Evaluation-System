package com.iiitb.assessmentBackEnd.rpack2;

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
import com.iiitb.assessmentBackEnd.rpack1.Rpack1;
import com.iiitb.assessmentBackEnd.rpack3.Rpack3;

@Entity
@Table(name = "rpack2")
public class Rpack2 {
	@Id 
	@Column(name = "rpack2_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rpack2_id;
	
	@ManyToOne
	@JoinColumn(name="rpack1_id")
	private Rpack1 rpack1;
	
	@Column(name="qp_id")
	private int qp_id;
	
	@Column(name = "qp_item_id")
	private int qp_item_id;
	
	@Column(name = "item_text")
	private String item_text;
	
	@Column(name = "item_marks")
	private float item_marks;
	
	@Column(name = "item_type")
	private String item_type;
	
	@Column(name = "cognitive_level")
	private String cognitive_level;
	
	@OneToMany(mappedBy = "rpack2")
	@JsonIgnore
	private List<Rpack3> rpack3List;
	
	public Rpack2() {
		super();
	}

	public Rpack2(int qp_id, int qp_item_id, String item_text, float item_marks, String item_type, String cognitive_level) {
		super();
		this.qp_id = qp_id;
		this.qp_item_id = qp_item_id;
		this.item_text = item_text;
		this.item_marks = item_marks;
		this.item_type = item_type;
		this.cognitive_level = cognitive_level;
	}

	public int getRpack2_id() {
		return rpack2_id;
	}

	public void setRpack2_id(int rpack2_id) {
		this.rpack2_id = rpack2_id;
	}

	public Rpack1 getRpack1() {
		return rpack1;
	}

	public void setRpack1(Rpack1 rpack1) {
		this.rpack1 = rpack1;
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

	public String getCognitive_level() {
		return cognitive_level;
	}

	public void setCognitive_level(String cognitive_level) {
		this.cognitive_level = cognitive_level;
	}
}
