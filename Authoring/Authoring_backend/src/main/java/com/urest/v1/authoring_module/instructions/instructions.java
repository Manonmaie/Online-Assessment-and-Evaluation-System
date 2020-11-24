package com.urest.v1.authoring_module.instructions;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urest.v1.authoring_module.questionPaper.questionPaper;

@Entity
@Table(name="au_instruction")
public class instructions {
	public instructions() { };
	
	public instructions(String instructionText) {
		super();
		this.instructionText=instructionText;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "instruction_id",updatable = false, nullable = false)
	private Integer instructionId;
	
	@Column(name="instruction_text")
	private String instructionText; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="qp_id")
	@JsonIgnore
	private questionPaper qp;

	public String getInstructionText() {
		return instructionText;
	}

	public void setInstructionText(String instructionText) {
		this.instructionText = instructionText;
	}

	public questionPaper getQp() {
		return qp;
	}

	public void setQp(questionPaper qp) {
		this.qp = qp;
	}
	
	public Integer getInstructionId() {
		return instructionId;
	}

	public void setInstructionId(Integer instructionId) {
		this.instructionId = instructionId;
	}

}
