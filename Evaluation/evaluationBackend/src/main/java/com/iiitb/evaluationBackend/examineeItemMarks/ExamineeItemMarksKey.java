package com.iiitb.evaluationBackend.examineeItemMarks;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExamineeItemMarksKey {
	
	@Column(name = "qp_item_id")
    private int qpItemId;
 
    @Column(name = "examinee_batch_id")
    private int examineeBatchId;
    
    public ExamineeItemMarksKey() {
    	
    }

	public ExamineeItemMarksKey(int qpItemId, int examineeBatchId) {
		super();
		this.qpItemId = qpItemId;
		this.examineeBatchId = examineeBatchId;
	}

	public int getQpItemId() {
		return qpItemId;
	}

	public void setQpItemId(int qpItemId) {
		this.qpItemId = qpItemId;
	}

	public int getExamineeBatchId() {
		return examineeBatchId;
	}

	public void setExamineeBatchId(int examineeBatchId) {
		this.examineeBatchId = examineeBatchId;
	}
    
    
}
