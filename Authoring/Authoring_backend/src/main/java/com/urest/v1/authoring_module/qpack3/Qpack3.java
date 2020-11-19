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
	
	@Column(name = "qp_item_id")
	private int qp_item_id;
	
	@Column(name = "item_option_id")
	private int item_option_id;
	
	@Column(name = "option_text")
	private String option_text;

	public Qpack3() {
		super();
	}

	public Qpack3(int item_id, int qp_item_id, int item_option_id, String option_text) {
		super();
		this.item_id = item_id;
		this.qp_item_id = qp_item_id;
		this.item_option_id = item_option_id;
		this.option_text = option_text;
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
