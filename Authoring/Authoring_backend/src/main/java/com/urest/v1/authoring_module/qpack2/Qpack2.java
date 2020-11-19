package com.urest.v1.authoring_module.qpack2;

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
import com.urest.v1.authoring_module.qpack1.Qpack1;
import com.urest.v1.authoring_module.qpack3.Qpack3;

@Entity
@Table(name = "qpack2")
public class Qpack2 {
	@Id 
	@Column(name = "qpack2_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qpack2_id;
	
	@ManyToOne
	@JoinColumn(name="qpack1_id")
	private Qpack1 qpack1;
	
	@Column(name="qp_id")
	private int qp_id;
	
	@Column(name = "item_id")
	private int item_id;
	
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
	
	@OneToMany(mappedBy = "qpack2")
	@JsonIgnore
	private List<Qpack3> qpack3List;

	public Qpack2() {
		super();
	}

	public Qpack2(int qp_id, int item_id, int qp_item_id, String item_text, float item_marks, String item_type,
			String cognitive_level) {
		super();
		this.qp_id = qp_id;
		this.item_id = item_id;
		this.qp_item_id = qp_item_id;
		this.item_text = item_text;
		this.item_marks = item_marks;
		this.item_type = item_type;
		this.cognitive_level = cognitive_level;
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

	public List<Qpack3> getQpack3List() {
		return qpack3List;
	}

	public void setQpack3List(List<Qpack3> qpack3List) {
		this.qpack3List = qpack3List;
	}

	public int getQpack2_id() {
		return qpack2_id;
	}

	public void setQpack2_id(int qpack2_id) {
		this.qpack2_id = qpack2_id;
	}

	public Qpack1 getQpack1() {
		return qpack1;
	}

	public void setQpack1(Qpack1 qpack1) {
		this.qpack1 = qpack1;
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

	public String getCognitive_level() {
		return cognitive_level;
	}

	public void setCognitive_level(String cognitive_level) {
		this.cognitive_level = cognitive_level;
	}
	
	
}
