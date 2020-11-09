package com.iiitb.assessmentBackEnd.examineeBatch;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExamineeBatchKey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "examinee_id")
    private int examineeId;
 
    @Column(name = "batch_id")
    private int batchId;
    
    public ExamineeBatchKey() {
    	
    }

	public ExamineeBatchKey(int examineeId, int batchId) {
		super();
		this.examineeId = examineeId;
		this.batchId = batchId;
	}

	public int getExamineeId() {
		return examineeId;
	}

	public void setExamineeId(int examineeId) {
		this.examineeId = examineeId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + examineeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamineeBatchKey other = (ExamineeBatchKey) obj;
		if (batchId != other.batchId)
			return false;
		if (examineeId != other.examineeId)
			return false;
		return true;
	}
}
