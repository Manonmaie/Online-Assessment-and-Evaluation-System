package com.iiitb.assessmentBackEnd.instruction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.questionPaper.AsQuestionPaper;

@Entity
public class AsInstruction {
	
	@Id
	private int instructionId;
	
	private String instructionCode;
	private String instructionText;
	
	@ManyToOne
	@JoinColumn(name="qp_id")
	@JsonIgnore
	private AsQuestionPaper asQuestionPaper;

	public AsInstruction() {
		
	}
	
	public AsInstruction(int instructionId, String instructionCode, int qpId, String instructionText) {
		super();
		this.instructionId = instructionId;
		this.instructionCode = instructionCode;
//		this.qpId = qpId;
		this.instructionText = instructionText;
		this.asQuestionPaper = new AsQuestionPaper();
		this.asQuestionPaper.setQpId(qpId);
	}

	public int getInstructionId() {
		return instructionId;
	}

	public void setInstructionId(int instructionId) {
		this.instructionId = instructionId;
	}

	public String getInstructionCode() {
		return instructionCode;
	}

	public void setInstructionCode(String instructionCode) {
		this.instructionCode = instructionCode;
	}

	public String getInstructionText() {
		return instructionText;
	}

	public void setInstructionText(String instructionText) {
		this.instructionText = instructionText;
	}
	
	public AsQuestionPaper getAsQuestionPaper() {
		return asQuestionPaper;
	}
	
	public void setAsQuestionPaper(AsQuestionPaper asQuestionPaper) {
		this.asQuestionPaper = asQuestionPaper;
	}
}
