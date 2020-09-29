package com.iiitb.assessmentBackEnd.examineeBatch;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.batch.AsBatch;
import com.iiitb.assessmentBackEnd.examinee.AsExaminee;

@Entity
public class AsExamineeBatch {
	
//	@Id
//	private int examineeBatchId;
	
	@EmbeddedId
    private ExamineeBatchKey examineeBatchId;
 
    @ManyToOne
    @MapsId("examineeId")
    @JoinColumn(name = "examinee_id")
    @JsonIgnore
    private AsExaminee examinee;
 
    @ManyToOne
    @MapsId("batchId")
    @JoinColumn(name = "batch_id")
    @JsonIgnore
    private AsBatch batch;

    public AsExamineeBatch() {
    	
    }
    
	public AsExamineeBatch(ExamineeBatchKey examineeBatchId, AsExaminee examinee, AsBatch batch) {
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

	public AsExaminee getExaminee() {
		return examinee;
	}

	public void setExaminee(AsExaminee examinee) {
		this.examinee = examinee;
	}

	public AsBatch getBatch() {
		return batch;
	}

	public void setBatch(AsBatch batch) {
		this.batch = batch;
	}
}
