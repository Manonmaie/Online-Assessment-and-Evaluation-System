package com.iiitb.examAdminBackEnd.examineeBatch;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.examAdminBackEnd.batch.Batch;
import com.iiitb.examAdminBackEnd.examinee.Examinee;
import com.iiitb.examAdminBackEnd.examineeItemMarks.ExamineeItemMarks;

@Entity
@Immutable
@Table (name = "ea_examinee_batch")
public class ExamineeBatch {

	@EmbeddedId
	private ExamineeBatchKey examineeBatchId;
	
	@ManyToOne
	@MapsId("examineeId")
	@JoinColumn(name = "examinee_id")
//	@JsonIgnore
	private Examinee examinee;
	
	@ManyToOne
	@MapsId("batchId")
	@JoinColumn(name = "batch_id")
	private Batch batch;
	
	@OneToMany(mappedBy = "examineeBatch")
	@JsonIgnore
	private List<ExamineeItemMarks> examineeItemMarksList;

	public ExamineeBatch() {
	}
	public ExamineeBatch(ExamineeBatchKey examineeBatchId, Examinee examinee, Batch batch) {
		super();
		this.examineeBatchId = examineeBatchId;
		this.examinee = examinee;
		this.batch = batch;
	}

	public ExamineeBatchKey getExamineeBatchId() {
		return examineeBatchId;
	}

	public void setExamineeBatchId(ExamineeBatchKey examineeBatchId) {
		this.examineeBatchId = examineeBatchId;
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
