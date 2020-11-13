package com.iiitb.evaluationBackend.qpItem;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.evaluationBackend.itemMcqOptions.EvItemMcqOptions;
import com.iiitb.evaluationBackend.itemTrueFalse.EvItemTrueFalse;
import com.iiitb.evaluationBackend.questionPaper.EvQuestionPaper;

@Entity
public class EvQpItem {
	
	@Id
	private int qpItemId;
	
	private String itemCode;
	private String itemText;
	private float itemMarks;
	private String itemType;
	
	@ManyToOne
	@JoinColumn(name="qp_id")
	@JsonIgnore
	private EvQuestionPaper evQuestionPaper;
	
	@OneToMany(mappedBy="evQpItem")
	private List<EvItemMcqOptions> evItemMcqOptionsList;
	
	@OneToMany(mappedBy="QpItemId")
	private List<EvItemTrueFalse> evItemTrueFalseList;

	public EvQpItem() {
		
	}
	
	public EvQpItem(int qpItemId, String itemCode, String itemText, float itemMarks, String itemType,int qpId) {
		super();
		this.qpItemId = qpItemId;
		this.itemCode = itemCode;
		this.itemText = itemText;
		this.itemMarks = itemMarks;
		this.itemType = itemType;
		this.evQuestionPaper = new EvQuestionPaper();
		this.evQuestionPaper.setQpId(qpId);
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

	public EvQuestionPaper getEvQuestionPaper() {
		return evQuestionPaper;
	}

	public void setEvQuestionPaper(EvQuestionPaper evQuestionPaper) {
		this.evQuestionPaper = evQuestionPaper;
	}

	public List<EvItemMcqOptions> getEvItemMcqOptionsList() {
		return evItemMcqOptionsList;
	}

	public void setEvItemMcqOptionsList(List<EvItemMcqOptions> evItemMcqOptionsList) {
		this.evItemMcqOptionsList = evItemMcqOptionsList;
	}
	
	public List<EvItemTrueFalse> getEvItemTrueFalseList() {
		return evItemTrueFalseList;
	}

	public void setEvItemTrueFalseList(List<EvItemTrueFalse> evItemTrueFalseList) {
		this.evItemTrueFalseList = evItemTrueFalseList;
	}
	
}
