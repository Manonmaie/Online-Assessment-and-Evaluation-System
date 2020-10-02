package com.urest.v1.authoring_module.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity // This tells Hibernate to make a table out of this class
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	public Item() {
		
	}

	public Item(Integer id, Integer marks, String question, String cg_lvl,String review_status,String item_status,Integer item_use_count) {
		super();
		// TODO Auto-generated constructor stub
		this.id = id;
		this.marks = marks;
		this.question = question;
		this.cg_lvl = cg_lvl;
		this.review_status=review_status;
		this.item_status=item_status;
		this.item_use_count=item_use_count;
	}

	private Integer marks;
	@Lob
	@Column(length=8192)
	private String question;

	private String cg_lvl;
	
	private String review_status="PENDING";
	private Integer item_use_count=0;
	private String item_status="ACTIVE";
	
	public Integer getItem_use_count() {
		return item_use_count;
	}

	public void setItem_use_count(Integer item_use_count) {
		this.item_use_count = item_use_count;
	}

	public String getItem_status() {
		return item_status;
	}

	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCg_lvl() {
		return cg_lvl;
	}

	public String getReview_status() {
		return review_status;
	}

	public void setReview_status(String review_status) {
		this.review_status = review_status;
	}

	public void setCg_lvl(String cg_lvl) {
		this.cg_lvl = cg_lvl;
	}
}

// marks,type,text,cg_lvl

//CREATE TABLE IF NOT EXISTS `item` (
//	    `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
//	    `itemtype_id` int(10) unsigned,
//	    `item_text` varchar(1024) NOT NULL,
//	    `cognitive_level` ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE') DEFAULT 'UNDERSTAND',
//	    `marks` int(4) unsigned NOT NULL,
//	    `review_status` ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING',
//	    `item_status` ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
//	    `item_use_count` int(10) unsigned DEFAULT 0,
//	    PRIMARY KEY (`item_id`)
//	);