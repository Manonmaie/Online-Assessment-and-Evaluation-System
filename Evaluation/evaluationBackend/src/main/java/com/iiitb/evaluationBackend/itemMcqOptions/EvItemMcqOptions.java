package com.iiitb.evaluationBackend.itemMcqOptions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.evaluationBackend.qpItem.EvQpItem;

@Entity
public class EvItemMcqOptions {
	
	@Id
	private int itemMcqId;
	
	private String itemMcqOptionsCode;
	private String mcqOptionText;
	
	@ManyToOne
	@JoinColumn(name="qp_item_id")
	@JsonIgnore
	private EvQpItem evQpItem;
	
	public EvItemMcqOptions() {
		
	}
	
	public EvItemMcqOptions(int itemMcqId, String itemMcqOptionsCode, String mcqOptionText, int qpItemId) {
		super();
		this.itemMcqId = itemMcqId;
		this.itemMcqOptionsCode = itemMcqOptionsCode;
		this.mcqOptionText = mcqOptionText;
		this.evQpItem = new EvQpItem();
		this.evQpItem.setQpItemId(qpItemId);
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

	public EvQpItem getEvQpItem() {
		return evQpItem;
	}

	public void setEvQpItem(EvQpItem evQpItem) {
		this.evQpItem = evQpItem;
	}
}
