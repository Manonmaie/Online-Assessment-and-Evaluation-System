package com.iiitb.evaluationBackend.evaluator;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.iiitb.evaluationBackend.examineeBatch.EvExamineeBatch;

@Entity
public class EvEvaluator {
	@Id
	private int evaluatorId;
	private String evaluatorCode;
	private String evaluatorName;
	private String evaluatorPassword;
	
	public EvEvaluator() {
		
	}

	public EvEvaluator(int evaluatorId,  String evaluatorCode, String evaluatorName, String evaluatorPassword) {
		super();
		this.evaluatorId = evaluatorId;
		this.evaluatorCode = evaluatorCode;
		this.evaluatorName = evaluatorName;
		this.evaluatorPassword = evaluatorPassword;
	}

	public int getEvaluatorId() {
		return evaluatorId;
	}

	public void setEvaluatorId(int evaluatorId) {
		this.evaluatorId = evaluatorId;
	}

	public String getEvaluatorName() {
		return evaluatorName;
	}

	public void setEvaluatorName(String evaluatorName) {
		this.evaluatorName = evaluatorName;
	}

	public String getEvaluatorCode() {
		return evaluatorCode;
	}

	public void setEvaluatorCode(String evaluatorCode) {
		this.evaluatorCode = evaluatorCode;
	}

	public String getEvaluatorPassword() {
		return evaluatorPassword;
	}

	public void setEvaluatorPassword(String evaluatorPassword) {
		this.evaluatorPassword = evaluatorPassword;
	}

	
	
}
