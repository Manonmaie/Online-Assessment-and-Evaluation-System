package com.urest.v1.authoring_module.item;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class

@Table(name = "item")
@SecondaryTable(name = "item_true_false", pkJoinColumns =@PrimaryKeyJoinColumn(name="item_id"))


public class Item {
	
	public Item() {
		
	}

	public Item(Integer id, Integer marks, String question, String cg_lvl,String review_status,String item_status,Integer item_use_count,String diff_lvl,String subject,String trueMarks,String falseMarks) {
		super();
		// TODO Auto-generated constructor stub
		this.item_id = id;
		this.marks = marks;
		this.question = question;
		this.cg_lvl = cg_lvl;
		this.review_status=review_status;
		this.item_status=item_status;
		this.item_use_count=item_use_count;
		this.diff_lvl=diff_lvl;
		this.falseMarks=falseMarks;
		this.trueMarks=trueMarks;
	}
	
	public Item(Integer id, Integer marks, String question, String cg_lvl,String review_status,String item_status,Integer item_use_count,String item_code) {
		super();
		// TODO Auto-generated constructor stub
		this.item_id = id;
		this.marks = marks;
		this.question = question;
		this.cg_lvl = cg_lvl;
		this.review_status=review_status;
		this.item_status=item_status;
		this.item_use_count=item_use_count;
		this.item_code=item_code;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Integer item_id;
	private Integer marks;
	@Lob
	@Column(length=8192)
	private String question;
	private String cg_lvl;
	private String diff_lvl;
	private String item_code;
	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	private String review_status="PENDING";
	private Integer item_use_count=0;
	private String item_status="ACTIVE";
	@Column(table = "item_true_false")
	private String trueMarks;
	@Column(table = "item_true_false")
	private String falseMarks;
	
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
		return item_id;
	}

	public void setId(Integer id) {
		this.item_id = id;
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
	
	public String getDiff_lvl() {
		return diff_lvl;
	}

	public void setDiff_lvl(String diff_lvl) {
		this.diff_lvl = diff_lvl;
	}

	public String getTrueMarks() {
		return trueMarks;
	}

	public void setTrueMarks(String trueMarks) {
		this.trueMarks = trueMarks;
	}

	public String getFalseMarks() {
		return falseMarks;
	}

	public void setFalseMarks(String falseMarks) {
		this.falseMarks = falseMarks;
	}

}




//CREATE TABLE IF NOT EXISTS `item` (     `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,     `item_code` varchar(255) UNIQUE NOT NULL,     `item_text` varchar(1024) NOT NULL,     `cognitive_level` ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE') DEFAULT 'UNDERSTAND',     `marks` int(4) unsigned NOT NULL,     `review_status` ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING',     `item_status` ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',     `item_use_count` int(10) unsigned DEFAULT 0,     PRIMARY KEY (`item_id`) );
//	);

//ALTER TABLE item_true_false
//ADD CONSTRAINT `fk_itemTrueFalse_item` FOREIGN KEY (item_id) REFERENCES item(item_id) ON DELETE SET NULL;
