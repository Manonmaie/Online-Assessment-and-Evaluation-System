package com.iiitb.evaluationBackend.response;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.iiitb.evaluationBackend.examineeBatch.EvExamineeBatch;
import com.iiitb.evaluationBackend.qpItem.EvQpItem;

@Entity
public class EvResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int responseId;
	
	private String responseCode;
	
	@ManyToOne
	@JoinColumn(name="qp_item_id")
	private EvQpItem evQpItem;
	
	@ManyToOne
	@JoinColumn(name="examinee_batch_id")
	private EvExamineeBatch evExamineeBatchId;
	
	public EvResponse() {
		
	}
	
	public EvResponse(int responseId, String responseText, int qpItemId, int attemptId) {
		super();
		this.responseId = responseId;
		this.responseCode = responseText;
		this.evQpItem = new EvQpItem();
		this.evQpItem.setQpItemId(qpItemId);
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

	public void setResponseCode(String responseText) {
		this.responseCode = responseText;
	}

	public EvQpItem getEvQpItem() {
		return evQpItem;
	}

	public void setEvQpItem(EvQpItem evQpItem) {
		this.evQpItem = evQpItem;
	}
	
	
}
