package com.urest.v1.authoring_module.apack2;

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
import com.urest.v1.authoring_module.apack1.Apack1;

@Entity
@Table(name = "apack2")
public class Apack2 {
	@Id 
	@Column(name = "apack2_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apack2_id;
	
	@ManyToOne
	@JoinColumn(name="apack1_id")
	private Apack1 apack1;
	
	@Column(name = "item_id")
	private int item_id;
	
	@Column(name = "qp_item_id")
	private int qp_item_id;
	
	@Column(name="item_option_id")
	private int item_option_id;
	
	@Column(name = "option_text")
	private String option_text;
	
	@Column(name="option_percentage")
	private int option_percentage;

	public Apack2() {
		super();
	}

	public Apack2(int item_id, int qp_item_id, int item_option_id, String option_text, int option_percentage) {
		super();
		this.item_id = item_id;
		this.qp_item_id = qp_item_id;
		this.item_option_id = item_option_id;
		this.option_text = option_text;
		this.option_percentage = option_percentage;
	}

	public int getQp_item_id() {
		return qp_item_id;
	}

	public void setQp_item_id(int qp_item_id) {
		this.qp_item_id = qp_item_id;
	}

	public int getApack2_id() {
		return apack2_id;
	}

	public void setApack2_id(int apack2_id) {
		this.apack2_id = apack2_id;
	}

	public Apack1 getApack1() {
		return apack1;
	}

	public void setApack1(Apack1 apack1) {
		this.apack1 = apack1;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
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

	public int getOption_percentage() {
		return option_percentage;
	}

	public void setOption_percentage(int option_percentage) {
		this.option_percentage = option_percentage;
	}
	
	
	
}
