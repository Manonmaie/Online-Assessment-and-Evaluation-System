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
    private EvQpItem qpItem;
 
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
    private EvExamineeBatch examineeBatch;
    
    public EvExamineeItemMarks() {
    	
    }

	public EvExamineeItemMarks(double examineeItemMarks, EvQpItem qpItem, EvExamineeBatch examineeBatch) {
		super();
		this.examineeItemMarks = examineeItemMarks;
		this.qpItem = qpItem;
		this.examineeBatch = examineeBatch;
	}

	public double getExamineeItemMarks() {
		return examineeItemMarks;
	}

	public EvQpItem getQpItem() {
		return qpItem;
	}

	public void setQpItem(EvQpItem qpItem) {
		this.qpItem = qpItem;
	}

	public EvExamineeBatch getExamineeBatch() {
		return examineeBatch;
	}

	public void setExamineeBatch(EvExamineeBatch examineeBatch) {
		this.examineeBatch = examineeBatch;
	}

    
}
