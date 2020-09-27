package com.iiitb.assessmentBackEnd.itemMcqOptions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.qpItem.AsQpItem;

@Entity
public class AsItemMcqOptions {
	
	@Id
	private int itemMcqId;
	
	private String itemMcqOptionsCode;
	private String mcqOptionText;
	
	@ManyToOne
	@JoinColumn(name="qp_item_id")
	@JsonIgnore
	private AsQpItem asQpItem;
	
	public AsItemMcqOptions() {
		
	}
	
	public AsItemMcqOptions(int itemMcqId, String itemMcqOptionsCode, String mcqOptionText, int qpItemId) {
		super();
		this.itemMcqId = itemMcqId;
		this.itemMcqOptionsCode = itemMcqOptionsCode;
		this.mcqOptionText = mcqOptionText;
		this.asQpItem = new AsQpItem();
		this.asQpItem.setQpItemId(qpItemId);
	}

	public int getItemMcqId() {
		return itemMcqId;
	}

	public void setItemMcqId(int itemMcqId) {
		this.itemMcqId = itemMcqId;
	}

	public String getItemMcqOptionsCode() {
		return itemMcqOptionsCode;
	}

	public void setItemMcqOptionsCode(String itemMcqOptionsCode) {
		this.itemMcqOptionsCode = itemMcqOptionsCode;
	}

	public String getMcqOptionText() {
		return mcqOptionText;
	}

	public void setMcqOptionText(String mcqOptionText) {
		this.mcqOptionText = mcqOptionText;
	}

	public AsQpItem getAsQpItem() {
		return asQpItem;
	}

	public void setAsQpItem(AsQpItem asQpItem) {
		this.asQpItem = asQpItem;
	}
}
