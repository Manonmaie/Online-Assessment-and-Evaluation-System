package com.iiitb.examAdminBackEnd.examineeBatch;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.examAdminBackEnd.batch.Batch;
import com.iiitb.examAdminBackEnd.examinee.Examinee;

@Entity
@Immutable
@Table (name = "ea_examinee_batch_marks")
public class ExamineeBatchMarks {

	@EmbeddedId
	private ExamineeBatchKey examineeBatchId;
	
	@Column (name = "examinee_batch_id")
	private int examineeBatchIdInt;
	
	private Float marksObtained;
	
	@ManyToOne
	@MapsId("examineeId")
	@JoinColumn(name = "examinee_id")
//	@JsonIgnore
	private Examinee examinee;
	
	@ManyToOne
	@MapsId("batchId")
	@JoinColumn(name = "batch_id")
	private Batch batch;

	public ExamineeBatchMarks() {
	}
	public ExamineeBatchMarks(ExamineeBatchKey examineeBatchId, Float marksObtained, Examinee examinee, Batch batch, int ExamineeBatchIdInt) {
		super();
		this.examineeBatchId = examineeBatchId;
		this.marksObtained = marksObtained;
		this.examinee = examinee;
		this.batch = batch;
		this.examineeBatchIdInt = examineeBatchIdInt;
	}

	public int getExamineeBatchIdInt() {
		return examineeBatchIdInt;
	}
	
	public void setExamineeBatchIdInt(int examineeBatchIdInt) {
		this.examineeBatchIdInt = examineeBatchIdInt;
	}
	
	public ExamineeBatchKey getExamineeBatchId() {
		return examineeBatchId;
	}

	public void setExamineeBatchId(ExamineeBatchKey examineeBatchId) {
		this.examineeBatchId = examineeBatchId;
	}

	public Float getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Float marksObtained) {
		this.marksObtained = marksObtained;
	}

	public Examinee getExaminee() {
		return examinee;
	}

	public void setExaminee(Examinee examinee) {
		this.examinee = examinee;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
}
