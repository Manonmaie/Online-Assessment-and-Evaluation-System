package com.iiitb.assessmentBackEnd.responseMcq;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.response.AsResponse;

@Entity
public class AsResponseMcq {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int responseMcqId;
	
	private String responseText;
	
	@OneToOne
//	@MapsId("responseId")
	@JoinColumn(name="response_id")
//	@JsonIgnore
	private AsResponse asResponse;
	
	public AsResponseMcq() {
		
	}

	public AsResponseMcq(int responseMcqId, String responseText, int responseId) {
		super();
		this.responseMcqId = responseMcqId;
		this.responseText = responseText;
		this.asResponse = new AsResponse();
		this.asResponse.setResponseId(responseId);
	}

	public int getResponseMcqId() {
		return responseMcqId;
	}

	public void setResponseMcqId(int responseMcqId) {
		this.responseMcqId = responseMcqId;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public AsResponse getAsResponse() {
		return asResponse;
	}

	public void setAsResponse(AsResponse asResponse) {
		this.asResponse = asResponse;
	}
}
