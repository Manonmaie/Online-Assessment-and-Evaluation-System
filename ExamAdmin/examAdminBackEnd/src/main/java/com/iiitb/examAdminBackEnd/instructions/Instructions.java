package com.iiitb.examAdminBackEnd.instructions;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.examAdminBackEnd.questionPaper.QuestionPaper;

@Entity
@Table(name = "ea_instruction")
public class Instructions {
	@Id 
	@Column(name = "instruction_id") 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instruction_id;
	
	@Column(name = "instruction_text")
	private String instruction_text;
	
	@ManyToOne
	@JoinColumn(name="qp_id")
//	@JsonIgnore
	private QuestionPaper questionPaper;

	public Instructions() {
		super();
	}

	public Instructions(int instruction_id, String instruction_text) {
		super();
		this.instruction_id = instruction_id;
		this.instruction_text = instruction_text;
	}

	public int getInstruction_id() {
		return instruction_id;
	}

	public void setInstruction_id(int instruction_id) {
		this.instruction_id = instruction_id;
	}

	public String getInstruction_text() {
		return instruction_text;
	}

	public void setInstruction_text(String instruction_text) {
		this.instruction_text = instruction_text;
	}

	public QuestionPaper getQuestionPaper() {
		return questionPaper;
	}

	public void setQuestionPaper(QuestionPaper questionPaper) {
		this.questionPaper = questionPaper;
	}
}
