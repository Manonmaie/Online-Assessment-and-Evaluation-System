package com.iiitb.examAdminBackEnd.epack2;

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
import com.iiitb.examAdminBackEnd.epack1.Epack1;

@Entity
@Table(name = "epack2")
public class Epack2 {
	@Id 
	@Column(name = "epack2_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int epack1_id;
	
	@ManyToOne
	@JoinColumn(name="epack1_id")
	private Epack1 epack1;
	
	@Column(name = "qp_id")
	private int qp_id;
	
	@Column(name = "item_id")
	private int item_id;
	
	@Column(name = "item_text")
	private String item_text;
	
	@Column(name = "item_marks")
	private float item_marks;
	
	@Column(name = "item_type")
	private String item_type;
	
	@Column(name = "cognitive_level")
	private String cognitive_level;
	
//	@OneToMany(mappedBy = "epack2")
//	@JsonIgnore
//	private List<epack3> epack3List;
	
	public Epack2() {
		super();
	}

	public Epack2(int qp_id, int item_id, String item_text, float item_marks, String item_type, String cognitive_level) {
		super();
		this.qp_id = qp_id;
		this.item_id = item_id;
		this.item_text = item_text;
		this.item_marks = item_marks;
		this.item_type = item_type;
		this.cognitive_level = cognitive_level;
	}

	public int getEpack1_id() {
		return epack1_id;
	}

	public void setEpack1_id(int epack1_id) {
		this.epack1_id = epack1_id;
	}

	public Epack1 getEpack1() {
		return epack1;
	}

	public void setEpack1(Epack1 epack1) {
		this.epack1 = epack1;
	}

	public int getQp_id() {
		return qp_id;
	}

	public void setQp_id(int qp_id) {
		this.qp_id = qp_id;
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
