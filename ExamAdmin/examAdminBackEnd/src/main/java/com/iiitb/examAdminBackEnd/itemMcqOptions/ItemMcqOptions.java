package com.iiitb.examAdminBackEnd.itemMcqOptions;

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
import com.iiitb.examAdminBackEnd.qp_item.QpItem;

@Entity
@Table(name = "ea_item_mcq_options")
public class ItemMcqOptions {
	@Id 
	@Column(name = "item_mcq_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_mcq_id;
	
	@ManyToOne
	@JoinColumn(name="qp_item_id")
//	@JsonIgnore
	private QpItem qpItem;
	
	@Column(name = "mcq_option_text")
	private String mcq_option_text;

	public ItemMcqOptions() {
		super();
	}

	public ItemMcqOptions(int item_mcq_id, String mcq_option_text) {
		super();
		this.item_mcq_id = item_mcq_id;
		this.mcq_option_text = mcq_option_text;
	}

	public int getItem_mcq_id() {
		return item_mcq_id;
	}

	public void setItem_mcq_id(int item_mcq_id) {
		this.item_mcq_id = item_mcq_id;
	}

	public QpItem getQpItem() {
		return qpItem;
	}

	public void setQpItem(QpItem qpItem) {
		this.qpItem = qpItem;
	}

	public String getMcq_option_text() {
		return mcq_option_text;
	}

	public void setMcq_option_text(String mcq_option_text) {
		this.mcq_option_text = mcq_option_text;
	}
}
