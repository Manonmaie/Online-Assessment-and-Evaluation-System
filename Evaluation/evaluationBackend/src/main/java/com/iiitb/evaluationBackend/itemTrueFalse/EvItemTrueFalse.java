package com.iiitb.evaluationBackend.itemTrueFalse;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EvItemTrueFalse {
	
	@Id
	private int itemTrueFalseId;
	
	private String itemTrueFalseCode;
	
	private int QpItemId;
	
	private float TruePercentage;
	
	private float FalsePercentage;

	public EvItemTrueFalse() {
		
	}

	public EvItemTrueFalse(int itemTrueFalseId, String itemTrueFalseCode, int qpItemId, float truePercentage,
			float falsePercentage) {
		super();
		this.itemTrueFalseId = itemTrueFalseId;
		this.itemTrueFalseCode = itemTrueFalseCode;
		QpItemId = qpItemId;
		TruePercentage = truePercentage;
		FalsePercentage = falsePercentage;
	}

	public int getQpItemId() {
		return QpItemId;
	}

	public void setQpItemId(int qpItemId) {
		QpItemId = qpItemId;
	}

	public float getTruePercentage() {
		return TruePercentage;
	}

	public void setTruePercentage(float truePercentage) {
		TruePercentage = truePercentage;
	}

	public float getFalsePercentage() {
		return FalsePercentage;
	}

	public void setFalsePercentage(float falsePercentage) {
		FalsePercentage = falsePercentage;
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

	
}