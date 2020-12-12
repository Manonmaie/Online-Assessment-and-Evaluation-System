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
import com.urest.v1.authoring_module.item.Item;
import com.urest.v1.authoring_module.questionPaper.questionPaper;

@JsonIgnoreProperties({ "QPItemId" })

@Entity // This tells Hibernate to make a table out of this class

@Table(name = "au_qp_item")
public class questionPaperItem {
	
	public questionPaperItem() {
		super();
	}

	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="item_id")
//	@JsonIgnore
	private Item item;
	
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="qp_id")
	@JsonIgnore
	private questionPaper QPItemId;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "qp_item_id",updatable = false, nullable = false)
	private Integer questionPaperItemId;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@JsonIgnore
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

	
}

