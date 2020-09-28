package com.iiitb.assessmentBackEnd.qpItem;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.itemMcqOptions.AsItemMcqOptions;
import com.iiitb.assessmentBackEnd.questionPaper.AsQuestionPaper;

@Entity
public class AsQpItem {
	
	@Id
	private int qpItemId;
	
	private String itemCode;
	private String itemText;
	private float itemMarks;
	private String itemType;
	private enum cognitiveLevelList { REMEMBER, UNDERSTAND, APPLY, ANALYZE, EVALUATE, CREATE};
	private String cognitiveLevel;
	
	@ManyToOne
	@JoinColumn(name="qp_id")
	@JsonIgnore
	private AsQuestionPaper asQuestionPaper;
	
	@OneToMany(mappedBy="asQpItem")
	private List<AsItemMcqOptions> asItemMcqOptionsList;

	public AsQpItem() {
		
	}
	
	public AsQpItem(int qpItemId, String itemCode, String itemText, float itemMarks, String itemType,
			String cognitiveLevel, int qpId) {
		super();
		this.qpItemId = qpItemId;
		this.itemCode = itemCode;
		this.itemText = itemText;
		this.itemMarks = itemMarks;
		this.itemType = itemType;
		this.cognitiveLevel = cognitiveLevel;
		this.asQuestionPaper = new AsQuestionPaper();
		this.asQuestionPaper.setQpId(qpId);
	}

	public int getQpItemId() {
		return qpItemId;
	}

	public void setQpItemId(int qpItemId) {
		this.qpItemId = qpItemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemText() {
		return itemText;
	}

	public void setItemText(String itemText) {
		this.itemText = itemText;
	}

	public float getItemMarks() {
		return itemMarks;
	}

	public void setItemMarks(float itemMarks) {
		this.itemMarks = itemMarks;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getCognitiveLevel() {
		return cognitiveLevel;
	}

	public void setCognitiveLevel(String cognitiveLevel) {
		this.cognitiveLevel = cognitiveLevel;
	}

	public AsQuestionPaper getAsQuestionPaper() {
		return asQuestionPaper;
	}

	public void setAsQuestionPaper(AsQuestionPaper asQuestionPaper) {
		this.asQuestionPaper = asQuestionPaper;
	}

	public List<AsItemMcqOptions> getAsItemMcqOptionsList() {
		return asItemMcqOptionsList;
	}

	public void setAsItemMcqOptionsList(List<AsItemMcqOptions> asItemMcqOptionsList) {
		this.asItemMcqOptionsList = asItemMcqOptionsList;
	}
	
}
