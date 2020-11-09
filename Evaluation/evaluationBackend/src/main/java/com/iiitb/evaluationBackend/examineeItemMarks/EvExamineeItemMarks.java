package com.iiitb.evaluationBackend.examineeItemMarks;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.evaluationBackend.qpItem.EvQpItem;

import com.iiitb.evaluationBackend.examineeBatch.EvExamineeBatch;

@Entity
public class EvExamineeItemMarks {
	
	@EmbeddedId
    private ExamineeItemMarksKey examineeItemMarksId;
	
	private double examineeItemMarks;
	 
    @ManyToOne
    @MapsId("qpItemId")
    @JoinColumn(name = "qp_item_id")
    @JsonIgnore
    private EvQpItem qpItemId;
 
    public ExamineeItemMarksKey getExamineeItemMarksId() {
		return examineeItemMarksId;
	}

	public void setExamineeItemMarksId(ExamineeItemMarksKey examineeItemMarksId) {
		this.examineeItemMarksId = examineeItemMarksId;
	}

	public void setExamineeItemMarks(double examineeItemMarks) {
		this.examineeItemMarks = examineeItemMarks;
	}

	@ManyToOne
    @MapsId("examineeBatchId")
    @JoinColumn(name = "examinee_batch_id")
    @JsonIgnore
    private EvExamineeBatch examineeBatchId;
    
    public EvExamineeItemMarks() {
    	
    }

	public EvExamineeItemMarks(float examineeItemMarks, EvQpItem qpItemId, EvExamineeBatch examineeBatchId) {
		super();
		this.examineeItemMarks = examineeItemMarks;
		this.qpItemId = qpItemId;
		this.examineeBatchId = examineeBatchId;
	}

	public double getExamineeItemMarks() {
		return examineeItemMarks;
	}

	public void setExamineeItemMarks(float examineeItemMarks) {
		this.examineeItemMarks = examineeItemMarks;
	}

	public EvQpItem getQpItemId() {
		return qpItemId;
	}

	public void setQpItemId(EvQpItem qpItemId) {
		this.qpItemId = qpItemId;
	}

	public EvExamineeBatch getExamineeBatchId() {
		return examineeBatchId;
	}

	public void setExamineeBatchId(EvExamineeBatch examineeBatchId) {
		this.examineeBatchId = examineeBatchId;
	}

    
}
