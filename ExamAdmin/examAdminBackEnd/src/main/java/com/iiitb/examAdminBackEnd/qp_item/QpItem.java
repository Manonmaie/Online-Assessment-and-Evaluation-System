package com.iiitb.examAdminBackEnd.qp_item;

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
import com.iiitb.examAdminBackEnd.examineeItemMarks.ExamineeItemMarks;
import com.iiitb.examAdminBackEnd.itemMcqOptions.ItemMcqOptions;
import com.iiitb.examAdminBackEnd.itemTrueFalse.ItemTrueFalse;
import com.iiitb.examAdminBackEnd.questionPaper.QuestionPaper;

@Entity
@Table(name = "ea_qp_item")
public class QpItem {
	@Id 
	@Column(name = "qp_item_id") 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qp_item_id;
	
	@ManyToOne
	@JoinColumn(name="qp_id")
//	@JsonIgnore
	private QuestionPaper questionPaper;
	
	@Column(name = "item_text")
	private String item_text;
	
	@Column(name = "item_marks")
	private float item_marks;
	
	@Column(name = "item_type")
	private String item_type;
	
	@Column(name = "cognitive_level")
	private String cognitive_level;
	
	@OneToMany(mappedBy = "qpItem")
	@JsonIgnore
	private List<ItemMcqOptions> itemMcqOptionsList;
	
	@OneToMany(mappedBy = "qpItem")
	@JsonIgnore
	private List<ItemTrueFalse> itemTrueFalseList;
	
	@OneToMany(mappedBy = "qpItem")
	@JsonIgnore
	private List<ExamineeItemMarks> examineeItemMarks;

	public QpItem() {
		super();
	}

	public QpItem(int qp_item_id, String item_text, float item_marks, String item_type,
			String cognitive_level) {
		super();
		this.qp_item_id = qp_item_id;
		this.item_text = item_text;
		this.item_marks = item_marks;
		this.item_type = item_type;
		this.cognitive_level = cognitive_level;
	}

	public int getQp_item_id() {
		return qp_item_id;
	}

	public void setQp_item_id(int qp_item_id) {
		this.qp_item_id = qp_item_id;
	}

	public QuestionPaper getQuestionPaper() {
		return questionPaper;
	}

	public void setQuestionPaper(QuestionPaper questionPaper) {
		this.questionPaper = questionPaper;
	}

	public String getItem_text() {
		return item_text;
	}

	public void setItem_text(String item_text) {
		this.item_text = item_text;
	}

	public float getItem_marks() {
		return item_marks;
	}

	public void setItem_marks(float item_marks) {
		this.item_marks = item_marks;
	}

	public String getItem_type() {
		return item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

	public String getCognitive_level() {
		return cognitive_level;
	}

	public void setCognitive_level(String cognitive_level) {
		this.cognitive_level = cognitive_level;
	}
}
