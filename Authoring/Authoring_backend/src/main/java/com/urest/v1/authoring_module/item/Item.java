package com.urest.v1.authoring_module.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	public Item() {
		
	}

	public Item(Integer id, Integer marks, String question, String cg_lvl) {
		super();
		// TODO Auto-generated constructor stub
		this.id = id;
		this.marks = marks;
		this.question = question;
		this.cg_lvl = cg_lvl;
	}

	private Integer marks;

	private String question;

	private String cg_lvl;

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