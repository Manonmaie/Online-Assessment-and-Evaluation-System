package com.iiitb.evaluationBackend.response;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.iiitb.evaluationBackend.qpItem.EvQpItem;
import com.iiitb.evaluationBackend.examineeBatch.EvExamineeBatch;

@Entity
public class EvResponse {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int responseId;
	
	private String responseCode;
	
	private String responseText;
	
	@ManyToOne
	@JoinColumn(name="qp_item_id")
	private EvQpItem evQpItem;
	
	@ManyToOne
	@JoinColumn(name="examinee_batch_id")
	private EvExamineeBatch evExamineeBatch;
	
	public EvResponse() {
		
	}

	public EvResponse(int responseId, String responseCode, String responseText, EvQpItem evQpItem,
			EvExamineeBatch evExamineeBatch) {
		super();
		this.responseId = responseId;
		this.responseCode = responseCode;
		this.responseText = responseText;
		this.evQpItem = evQpItem;
		this.evExamineeBatch = evExamineeBatch;
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public EvQpItem getEvQpItem() {
		return evQpItem;
	}

	public void setEvQpItem(EvQpItem evQpItem) {
		this.evQpItem = evQpItem;
	}

	public EvExamineeBatch getEvExamineeBatch() {
		return evExamineeBatch;
	}

	public void setEvExamineeBatch(EvExamineeBatch evExamineeBatch) {
		this.evExamineeBatch = evExamineeBatch;
	}
	
	
	
	
}
