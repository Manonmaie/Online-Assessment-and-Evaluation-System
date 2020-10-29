package com.urest.v1.authoring_module.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.urest.v1.authoring_module.options.OptionsStruct;

public class ResponseStruct {
	public ResponseStruct() {
		
	}
	
	public ResponseStruct(Integer id, Integer marks, String itemText, String cgLvl,String reviewStatus,String itemStatus,Integer itemUseCount,String diffLvl,String subject,Integer authorId,ArrayList<OptionsStruct> options,Integer trueMarks,Integer falseMarks) {
		super();
		// TODO Auto-generated constructor stub
		this.marks = marks;
		this.itemText = itemText;
		this.cgLvl = cgLvl;
		this.reviewStatus=reviewStatus;
		this.itemStatus=itemStatus;
		this.itemUseCount=itemUseCount;
		this.diffLvl=diffLvl;
		this.authorId=authorId;
		this.trueMarks=trueMarks;
		this.falseMarks=falseMarks;
		this.options=options;
	}
	


	private String itemText;
	private String cgLvl;
	private String diffLvl;
	private Integer authorId;
	private Integer marks;
	private String reviewStatus="PENDING";
	private Integer itemUseCount=0;
	private String itemStatus="ACTIVE";
	private ArrayList<OptionsStruct> options;
	private Integer trueMarks;
	private Integer falseMarks;
	private String itemType;

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
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

	public String getItemText() {
		return itemText;
	}
	public void setItemText(String itemText) {
		this.itemText = itemText;
	}
	public String getCgLvl() {
		return cgLvl;
	}
	public void setCgLvl(String cgLvl) {
		this.cgLvl = cgLvl;
	}
	public String getDiffLvl() {
		return diffLvl;
	}
	public void setDiffLvl(String diffLvl) {
		this.diffLvl = diffLvl;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public Integer getItemUseCount() {
		return itemUseCount;
	}
	public void setItemUseCount(Integer itemUseCount) {
		this.itemUseCount = itemUseCount;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	public ArrayList<OptionsStruct> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<OptionsStruct> options) {
		this.options = options;
	}



	



}
