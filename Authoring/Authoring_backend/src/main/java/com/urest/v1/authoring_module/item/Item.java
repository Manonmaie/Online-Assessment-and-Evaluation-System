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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.urest.v1.authoring_module.TF.TF;
import com.urest.v1.authoring_module.course.AuCourseMaster;
import com.urest.v1.authoring_module.options.Options;

@Entity // This tells Hibernate to make a table out of this class

@Table(name = "au_item")
public class Item {
	
	public Item() {
		super();
	}
	public Item(Integer itemId, Integer marks, String itemText, String cgLvl,String reviewStatus,String itemStatus,Integer itemUseCount,String diffLvl,String subject,Integer authorId,String itemType) {
		
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
	@Column(updatable = false, nullable = false,name="item_id")
	private Integer itemId;
	
	@Lob
	@Column(length=8192,name="item_text")
	private String itemText;
	@Column(name="cognitive_level")
	private String cgLvl;
	@Column(name="difficulty_level")
	private String diffLvl;
	@Column(name="author_id")
	private Integer authorId;
	@Column(name="marks")
	private Integer marks;
	@Column(name="review_status")
	private String reviewStatus="PENDING";
	@Column(name="item_use_count")
	private Integer itemUseCount=0;
	@Column(name="item_status")
	private String itemStatus="ACTIVE";
	@Column(name="item_type")
	private String itemType;
	
	@OneToMany(mappedBy="itemTF", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,orphanRemoval = true)
	private List<TF> asItemTF=new ArrayList<TF>();
	
	
	@OneToMany(mappedBy="itemMCQ", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Options> asItemMCQ=new ArrayList<Options>();
	
	
	@OneToOne
	@JoinColumn(name="course_master_id")
	private AuCourseMaster course=new AuCourseMaster();
	
	public AuCourseMaster getCourse() {
		return course;
	}
	public void setCourse(AuCourseMaster course) {
		this.course = course;
	}
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
