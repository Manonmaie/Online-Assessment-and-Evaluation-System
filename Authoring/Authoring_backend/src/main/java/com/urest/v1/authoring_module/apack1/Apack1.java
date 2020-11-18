package com.urest.v1.authoring_module.apack1;

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
import com.urest.v1.authoring_module.apack.Apack;
import com.urest.v1.authoring_module.apack2.Apack2;

@Entity
@Table(name = "apack1")
public class Apack1 {
	@Id 
	@Column(name = "apack1_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apack1_id;
	
	@ManyToOne
	@JoinColumn(name="apack_header_id")
	private Apack apack_header;
	
	@Column(name="qp_id")
	private int qp_id;
	
	@Column(name = "item_id")
	private int item_id;
	
	@Column(name = "item_text")
	private String item_text;
	
	@Column(name = "item_marks")
	private float item_marks;
	
	@Column(name = "item_type")
	private String item_type;

	@OneToMany(mappedBy = "apack1")
	@JsonIgnore
	private List<Apack2> apack2List;
	
	public Apack1() {
		super();
	}

	public Apack1(int qp_id, int item_id, String item_text, float item_marks, String item_type) {
		super();
		this.qp_id = qp_id;
		this.item_id = item_id;
		this.item_text = item_text;
		this.item_marks = item_marks;
		this.item_type = item_type;
	}

	public int getApack1_id() {
		return apack1_id;
	}

	public void setApack1_id(int apack1_id) {
		this.apack1_id = apack1_id;
	}

	public Apack getApack_header() {
		return apack_header;
	}

	public void setApack_header(Apack apack_header) {
		this.apack_header = apack_header;
	}

	public int getQp_id() {
		return qp_id;
	}

	public void setQp_id(int qp_id) {
		this.qp_id = qp_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
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
