package com.iiitb.assessmentBackEnd.itemTrueFalse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.qpItem.AsQpItem;

@Entity
public class AsItemTrueFalse {
	
	@Id
	private int itemTrueFalseId;
	
	private String itemTrueFalseCode;
	
	@ManyToOne
	@JoinColumn(name="qp_item_id")
	@JsonIgnore
	private AsQpItem asQpItem;

	public AsItemTrueFalse() {
		
	}
	
	public AsItemTrueFalse(int itemTrueFalseId, String itemTrueFalseCode, int qpItemId) {
		super();
		this.itemTrueFalseId = itemTrueFalseId;
		this.itemTrueFalseCode = itemTrueFalseCode;
		this.asQpItem = new AsQpItem();
		this.asQpItem.setQpItemId(qpItemId);
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

	public AsQpItem getAsQpItem() {
		return asQpItem;
	}

	public void setAsQpItem(AsQpItem asQpItem) {
		this.asQpItem = asQpItem;
	}
}
