package com.iiitb.assessmentBackEnd.response;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iiitb.assessmentBackEnd.attempt.AsAttempt;
import com.iiitb.assessmentBackEnd.qpItem.AsQpItem;
import com.iiitb.assessmentBackEnd.responseMcq.AsResponseMcq;

@Entity
//@Table(name="as_response")
//@SecondaryTable(name = "as_response_mcq", pkJoinColumns=@PrimaryKeyJoinColumn(name="response_id"))
public class AsResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int responseId;
	
	private String responseText;
	
	@ManyToOne
	@JoinColumn(name="qp_item_id")
	private AsQpItem asQpItem;
	
	@ManyToOne
	@JoinColumn(name="attempt_id")
	private AsAttempt asAttempt;
	
	public AsResponse() {
		
	}

	public AsResponse(int responseId, String responseText, int qpItemId, int attemptId) {
		super();
		this.responseId = responseId;
		this.responseText = responseText;
		this.asQpItem = new AsQpItem();
		this.asQpItem.setQpItemId(qpItemId);
		this.asAttempt = new AsAttempt();
		this.asAttempt.setAttemptId(attemptId);
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}
	
	public AsQpItem getAsQpItem() {
		return asQpItem;
	}

	public void setAsQpItem(AsQpItem asQpItem) {
		this.asQpItem = asQpItem;
	}

	public AsAttempt getAsAttempt() {
		return asAttempt;
	}

	public void setAsAttempt(AsAttempt asAttempt) {
		this.asAttempt = asAttempt;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
}
