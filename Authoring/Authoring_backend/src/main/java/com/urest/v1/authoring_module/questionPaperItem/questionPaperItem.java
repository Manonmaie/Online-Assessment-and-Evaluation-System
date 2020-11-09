package com.urest.v1.authoring_module.questionPaperItem;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.urest.v1.authoring_module.questionPaper.questionPaper;

@JsonIgnoreProperties(value = { "questionPaper" })

@Entity // This tells Hibernate to make a table out of this class

@Table(name = "question_paper_item")
public class questionPaperItem {
	
	public questionPaperItem(int itemId) {
		this.itemId=itemId;
	}


	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="question_paper_id")
	@JsonIgnore
	private questionPaper QPItemId;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "question_paper_item_id",updatable = false, nullable = false)
	private Integer questionPaperItemId;
	private Integer itemId;

	public questionPaper getQPItemId() {
		return QPItemId;
	}

	public void setQPItemId(questionPaper qPItemId) {
		QPItemId = qPItemId;
	}

	public Integer getQuestionPaperItemId() {
		return questionPaperItemId;
	}

	public void setQuestionPaperItemId(Integer questionPaperItemId) {
		this.questionPaperItemId = questionPaperItemId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	
}

