package com.urest.v1.authoring_module.TF;


import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.urest.v1.authoring_module.item.Item;
@JsonIgnoreProperties(value = { "item" })

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "au_item_true_false")
public class TF {
	public TF() {}
	public TF(Integer trueMarks,Integer falseMarks) {
		super();
		// TODO Auto-generated constructor stub
		this.trueMarks=trueMarks;
		this.falseMarks=falseMarks;
	}
	
	public Item getItem() {
		return itemTF;
	}
	public void setItem(Item item) {
		this.itemTF = item;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable = false, nullable = false,name="item_true_false_id")
	private Integer itemTrueFalseId;
	@Column(name="true_percent")
	private Integer trueMarks;
	@Column(name="false_percent")
	private Integer falseMarks;
	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="item_id")
	@JsonIgnore
	private Item itemTF;
	
	public Integer getItemTrueFalseId() {
		return itemTrueFalseId;
	}
	public void setItemTrueFalseId(Integer itemTrueFalseId) {
		this.itemTrueFalseId = itemTrueFalseId;
	}
	public Integer getTrueMarks() {
		return trueMarks;
	}
	public void setTrueMarks(Integer trueMarks) {
		this.trueMarks = trueMarks;
	}
	public Integer getFalseMarks() {
		return falseMarks;
	}
	public void setFalseMarks(Integer falseMarks) {
		this.falseMarks = falseMarks;
	}
	public Item getItemTF() {
		return itemTF;
	}
	public void setItemTF(Item itemTF) {
		this.itemTF = itemTF;
	}
	

}
