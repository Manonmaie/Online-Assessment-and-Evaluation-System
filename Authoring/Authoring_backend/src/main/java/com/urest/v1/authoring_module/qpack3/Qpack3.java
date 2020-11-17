package com.urest.v1.authoring_module.qpack3;

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
import com.urest.v1.authoring_module.qpack2.Qpack2;

@Entity
@Table(name = "qpack3")
public class Qpack3 {
	@Id 
	@Column(name = "qpack3_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qpack3_id;
	
	@ManyToOne
	@JoinColumn(name="qpack2_id")
	private Qpack2 qpack2;
	
	@Column(name = "item_id")
	private int item_id;
	
	@Column(name = "item_mcq_id")
	private int item_mcq_id;
	
	@Column(name = "mcq_option_text")
	private String mcq_option_text;

	public Qpack3() {
		super();
	}

	public Qpack3(int item_id, int item_mcq_id, String mcq_option_text) {
		super();
		this.item_id = item_id;
		this.item_mcq_id = item_mcq_id;
		this.mcq_option_text = mcq_option_text;
	}

	public int getQpack3_id() {
		return qpack3_id;
	}

	public void setQpack3_id(int qpack3_id) {
		this.qpack3_id = qpack3_id;
	}

	public Qpack2 getQpack2() {
		return qpack2;
	}

	public void setQpack2(Qpack2 qpack2) {
		this.qpack2 = qpack2;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getItem_mcq_id() {
		return item_mcq_id;
	}

	public void setItem_mcq_id(int item_mcq_id) {
		this.item_mcq_id = item_mcq_id;
	}

	public String getMcq_option_text() {
		return mcq_option_text;
	}

	public void setMcq_option_text(String mcq_option_text) {
		this.mcq_option_text = mcq_option_text;
	}
}
