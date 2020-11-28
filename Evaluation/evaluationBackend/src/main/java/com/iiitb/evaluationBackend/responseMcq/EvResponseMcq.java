package com.iiitb.evaluationBackend.responseMcq;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.iiitb.evaluationBackend.response.EvResponse;

@Entity
public class EvResponseMcq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int responseMcqId;
	
	private String responseText;
	
	@OneToOne
	@JoinColumn(name="response_id")
	private EvResponse evResponse;
	
	public EvResponseMcq() {
		
	}

	public EvResponseMcq(int responseMcqId, String responseText, int responseId) {
		super();
		this.responseMcqId = responseMcqId;
		this.responseText = responseText;
		this.evResponse = new EvResponse();
		this.evResponse.setResponseId(responseId);
	}

	public EvResponse getEvResponse() {
		return evResponse;
	}

	public void setEvResponse(EvResponse evResponse) {
		this.evResponse = evResponse;
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
}
