package com.iiitb.examAdminBackEnd.examineeItemMarks;

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
import com.iiitb.examAdminBackEnd.examineeBatch.ExamineeBatch;
import com.iiitb.examAdminBackEnd.qp_item.QpItem;

@Entity
@Table(name = "ea_examinee_item_marks")
public class ExamineeItemMarks {
	@Id 
	@Column(name = "examinee_item_marks_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int examinee_item_marks_id;
	
	@ManyToOne
	@JoinColumn(name="qp_item_id")
	private QpItem qpItem;
	
	@ManyToOne
	@JoinColumn(name="examinee_batch_id")
	private ExamineeBatch examineeBatch;
	
	@Column(name = "marks_obtained")
	private float marks_obtained;

	public ExamineeItemMarks() {
		super();
	}

	public ExamineeItemMarks(float marks_obtained) {
		super();
		this.marks_obtained = marks_obtained;
	}

	public int getExaminee_item_marks_id() {
		return examinee_item_marks_id;
	}

	public void setExaminee_item_marks_id(int examinee_item_marks_id) {
		this.examinee_item_marks_id = examinee_item_marks_id;
	}

	public QpItem getQpItem() {
		return qpItem;
	}

	public void setQpItem(QpItem qpItem) {
		this.qpItem = qpItem;
	}

	public ExamineeBatch getExamineeBatch() {
		return examineeBatch;
	}

	public void setExamineeBatch(ExamineeBatch examineeBatch) {
		this.examineeBatch = examineeBatch;
	}

	public float getMarks_obtained() {
		return marks_obtained;
	}

	public void setMarks_obtained(float marks_obtained) {
		this.marks_obtained = marks_obtained;
	}
}
