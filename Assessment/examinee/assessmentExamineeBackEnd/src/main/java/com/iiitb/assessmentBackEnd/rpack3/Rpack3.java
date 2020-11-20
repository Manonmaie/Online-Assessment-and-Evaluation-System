package com.iiitb.assessmentBackEnd.rpack3;


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
@Table(name = "rpack3")
public class Rpack3 {
	@Id 
	@Column(name = "rpack3_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rpack3_id;
	
	@ManyToOne
	@JoinColumn(name="rpack2_id")
	private Rpack2 rpack2;
	
	@Column(name = "qp_item_id")
	private int qp_item_id;
	
	@Column(name = "item_option_id")
	private int item_option_id;
	
	@Column(name = "option_text")
	private String option_text;

	public Rpack3() {
		super();
	}

	public Rpack3(int qp_item_id, int item_option_id, String option_text) {
		super();
		this.qp_item_id = qp_item_id;
		this.item_option_id = item_option_id;
		this.option_text = option_text;
	}

	public int getRpack3_id() {
		return rpack3_id;
	}

	public void setRpack3_id(int rpack3_id) {
		this.rpack3_id = rpack3_id;
	}

	public Rpack2 getRpack2() {
		return rpack2;
	}

	public void setRpack2(Rpack2 rpack2) {
		this.rpack2 = rpack2;
	}

	public int getQp_item_id() {
		return qp_item_id;
	}

	public void setQp_item_id(int qp_item_id) {
		this.qp_item_id = qp_item_id;
	}

	public int getItem_option_id() {
		return item_option_id;
	}

	public void setItem_option_id(int item_option_id) {
		this.item_option_id = item_option_id;
	}

	public String getOption_text() {
		return option_text;
	}

	public void setOption_text(String option_text) {
		this.option_text = option_text;
	}
}
