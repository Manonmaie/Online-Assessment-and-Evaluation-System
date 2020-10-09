package com.iiitb.evaluationBackend.itemTrueFalse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.evaluationBackend.qpItem.EvQpItem;

@Entity
public class EvItemTrueFalse {
	
	@Id
	private int itemTrueFalseId;
	
	private String itemTrueFalseCode;
	
	@ManyToOne
	@JoinColumn(name="qp_item_id")
	@JsonIgnore
	private EvQpItem evQpItem;

	public EvItemTrueFalse() {
		
	}
	
	public EvItemTrueFalse(int itemTrueFalseId, String itemTrueFalseCode, int qpItemId) {
		super();
		this.itemTrueFalseId = itemTrueFalseId;
		this.itemTrueFalseCode = itemTrueFalseCode;
		this.evQpItem = new EvQpItem();
		this.evQpItem.setQpItemId(qpItemId);
	}

	public int getItemTrueFalseId() {
		return itemTrueFalseId;
	}

	public void setItemTrueFalseId(int itemTrueFalseId) {
		this.itemTrueFalseId = itemTrueFalseId;
	}

	public String getItemTrueFalseCode() {
		return itemTrueFalseCode;
	}

	public void setItemTrueFalseCode(String itemFrueFalseCode) {
		this.itemTrueFalseCode = itemFrueFalseCode;
	}

	public EvQpItem getAsQpItem() {
		return evQpItem;
	}

	public void setAsQpItem(EvQpItem evQpItem) {
		this.evQpItem = evQpItem;
	}
}