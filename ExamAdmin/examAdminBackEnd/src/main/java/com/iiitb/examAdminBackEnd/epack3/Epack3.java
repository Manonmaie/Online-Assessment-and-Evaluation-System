package com.iiitb.examAdminBackEnd.epack3;

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
import com.iiitb.examAdminBackEnd.epack2.Epack2;

@Entity
@Table(name = "epack3")
public class Epack3 {
	@Id 
	@Column(name = "epack3_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int epack3_id;
	
	@ManyToOne
	@JoinColumn(name="epack2_id")
	private Epack2 epack2;
	
	@Column(name = "item_id")
	private int item_id;
	
	@Column(name = "item_option_id")
	private int item_option_id;
	
	@Column(name = "option_text")
	private String option_text;

	public Epack3() {
		super();
	}

	public Epack3(int item_id, int item_option_id, String option_text) {
		super();
		this.item_id = item_id;
		this.item_option_id = item_option_id;
		this.option_text = option_text;
	}

	public int getEpack3_id() {
		return epack3_id;
	}

	public void setEpack3_id(int epack3_id) {
		this.epack3_id = epack3_id;
	}

	public Epack2 getEpack2() {
		return epack2;
	}

	public void setEpack2(Epack2 epack2) {
		this.epack2 = epack2;
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
}
