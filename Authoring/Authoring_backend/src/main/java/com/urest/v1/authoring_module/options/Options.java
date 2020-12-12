package com.urest.v1.authoring_module.options;

import javax.persistence.CascadeType;

//import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.urest.v1.authoring_module.item.Item;
@JsonIgnoreProperties(value = { "item" })

@Entity // This tells Hibernate to make a table out of this class

@Table(name = "au_item_mcq_options")
public class Options {
	
	public Options() {
		
	}
	
	public Options(String mcqOptionText,Integer mcqOptionMarks) {
		super();
		// TODO Auto-generated constructor stub
		this.mcqOptionMarks = mcqOptionMarks;
		this.mcqOptionText = mcqOptionText;
	}


	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="item_id")
	@JsonIgnore
	private Item itemMCQ;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "item_mcq_id",updatable = false, nullable = false)
	private Integer item_mcq_options_id;
	@Column(name = "mcq_option_marks")
	private Integer mcqOptionMarks;
	@Column(name = "mcq_option_text")
	private String mcqOptionText;
	
	public Integer getItem_mcq_options_id() {
		return item_mcq_options_id;
	}

	public void setItem_mcq_options_id(Integer item_mcq_options_id) {
		this.item_mcq_options_id = item_mcq_options_id;
	}
	
	public Item getItemMCQ() {
		return itemMCQ;
	}

	public void setItemMCQ(Item itemMCQ) {
		this.itemMCQ = itemMCQ;
	}

	public Integer getMcqOptionMarks() {
		return mcqOptionMarks;
	}

	public void setMcqOptionMarks(Integer mcqOptionMarks) {
		this.mcqOptionMarks = mcqOptionMarks;
	}

	public String getMcqOptionText() {
		return mcqOptionText;
	}

	public void setMcqOptionText(String mcqOptionText) {
		this.mcqOptionText = mcqOptionText;
	}
	
}

