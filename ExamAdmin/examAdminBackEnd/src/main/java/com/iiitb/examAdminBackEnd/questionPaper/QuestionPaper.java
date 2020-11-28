package com.iiitb.examAdminBackEnd.questionPaper;

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
import com.iiitb.examAdminBackEnd.batch.Batch;
import com.iiitb.examAdminBackEnd.instructions.Instructions;
import com.iiitb.examAdminBackEnd.qp_item.QpItem;

@Entity
@Table(name = "ea_question_paper")
public class QuestionPaper {
	@Id 
	@Column(name = "qp_id") 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qp_id;
	
	@OneToOne
	@JoinColumn(name="batch_id")
	private Batch batch;
	
//	@Column(name = "batch_id")
//	private int batch_id;
	
	@Column(name = "maximum_marks")
	private float maximum_marks;
	
	@Column(name = "duration")
	private int duration;
	
	@OneToMany(mappedBy = "questionPaper")
	@JsonIgnore
	private List<Instructions> instructionList;
	
	@OneToMany(mappedBy = "questionPaper")
	@JsonIgnore
	private List<QpItem> qpItemList;

	public QuestionPaper() {
		super();
	}

	public QuestionPaper(int qp_id, Batch batch, float maximum_marks, int duration) {
		super();
		this.qp_id = qp_id;
		this.batch = batch;
		this.maximum_marks = maximum_marks;
		this.duration = duration;
	}

	public int getQp_id() {
		return qp_id;
	}

	public void setQp_id(int qp_id) {
		this.qp_id = qp_id;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public float getMaximum_marks() {
		return maximum_marks;
	}

	public void setMaximum_marks(float maximum_marks) {
		this.maximum_marks = maximum_marks;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
