package com.urest.v1.authoring_module.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.urest.v1.authoring_module.TF.TF;
import com.urest.v1.authoring_module.options.Options;

@Entity // This tells Hibernate to make a table out of this class

@Table(name = "item")


public class Item {
	
	public Item() {
		System.out.println("vani");
	}
	public Item(Integer itemId, Integer marks, String itemText, String cgLvl,String reviewStatus,String itemStatus,Integer itemUseCount,String diffLvl,String subject,Integer authorId,String itemType) {
		super();
		
		// TODO Auto-generated constructor stub
		this.itemId = itemId;
		this.marks = marks;
		this.itemText = itemText;
		this.cgLvl = cgLvl;
		this.reviewStatus=reviewStatus;
		this.itemStatus=itemStatus;
		this.itemUseCount=itemUseCount;
		this.diffLvl=diffLvl;
		this.authorId=authorId;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Integer itemId;
	
	@Lob
	@Column(length=8192)
	private String itemText;
	private String cgLvl;
	private String diffLvl;
	private Integer authorId;
	private Integer marks;
	private String reviewStatus="PENDING";
	private Integer itemUseCount=0;
	private String itemStatus="ACTIVE";
	private String itemType;
	
	@OneToMany(mappedBy="itemTF", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,orphanRemoval = true)
	private List<TF> asItemTF=new ArrayList<TF>();
	
	
	@OneToMany(mappedBy="itemMCQ", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Options> asItemMCQ=new ArrayList<Options>();
	
	
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public List<Options> getAsItemMCQ() {
		return asItemMCQ;
	}
	public void setAsItemMCQ(List<Options> asItemMCQ) {
		this.asItemMCQ = asItemMCQ;
	}
	public List<TF> getAsItemTF() {
		return asItemTF;
	}
	public void setAsItemTF(List<TF> asItemTF) {
		this.asItemTF = asItemTF;
	}

	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemText() {
		return itemText;
	}
	public void setItemText(String itemText) {
		this.itemText = itemText;
	}
	public String getCgLvl() {
		return cgLvl;
	}
	public void setCgLvl(String cgLvl) {
		this.cgLvl = cgLvl;
	}
	public String getDiffLvl() {
		return diffLvl;
	}
	public void setDiffLvl(String diffLvl) {
		this.diffLvl = diffLvl;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public Integer getItemUseCount() {
		return itemUseCount;
	}
	public void setItemUseCount(Integer itemUseCount) {
		this.itemUseCount = itemUseCount;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

}



//CREATE TABLE IF NOT EXISTS `item` (     
//		`item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
//		`item_text` varchar(1024) NOT NULL,
//		`cognitive_level` ENUM('REMEMBER', 'UNDERSTAND', 'APPLY', 'ANALYZE', 'EVALUATE', 'CREATE') DEFAULT 'UNDERSTAND',
//		`marks` int(4) unsigned NOT NULL,
//		`review_status` ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING',
//		`item_status` ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
//		`item_use_count` int(10) unsigned DEFAULT 0,
//		`author_id` int(10)unsigned,
//		PRIMARY KEY (`item_id`) );
//
//CREATE TABLE IF NOT EXISTS `item_true_false` (
//	    `item_true_false_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
//	    `item_id` int(10) unsigned,
//	    `true_marks` int(10) unsigned,
//	    `false_marks` int(10) unsigned,
//	    PRIMARY KEY (`item_true_false_id`)
//	);
//
//ALTER TABLE item_true_false
//ADD CONSTRAINT `fk_itemTrueFalse_item` FOREIGN KEY (item_id) REFERENCES item(item_id) ON DELETE SET NULL;
//
//
//CREATE TABLE IF NOT EXISTS `item_mcq_options` (
//	    `item_mcq_options_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
//	    `item_id` int(10) unsigned,
//	    `mcq_option_text` varchar(255) NOT NULL,
//	    `mcq_option_marks` int(10),
//	    PRIMARY KEY (`item_mcq_options_id`)
//	);
//
//	ALTER TABLE item_mcq_options
//	  ADD CONSTRAINT `fk_itemMcqOptions_item` FOREIGN KEY (item_id) REFERENCES item(item_id) ON DELETE SET NULL;
