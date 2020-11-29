package com.urest.v1.authoring_module.questionPaper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urest.v1.authoring_module.course.AuCourseMaster;
import com.urest.v1.authoring_module.instructions.instructions;
import com.urest.v1.authoring_module.item.Item;
import com.urest.v1.authoring_module.options.Options;
import com.urest.v1.authoring_module.questionPaperItem.questionPaperItem;



@Entity // This tells Hibernate to make a table out of this class

@Table(name = "au_question_paper")
public class questionPaper {
	questionPaper(){
		super();
	}
	questionPaper(int timeDuration,int totalMarks,String batchCode){
		this.timeDuration=timeDuration;
		this.totalMarks=totalMarks;
		this.batchCode=batchCode;
	}
	
	
	// --------------------------------------------------------------------------------
	@Transient private List<Item> items;
	@Transient private List<String> inst;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="qp_id", updatable = false, nullable = false)
	private Integer questionPaperId;
	@Column(name="duration")
	private int timeDuration;
	@Column(name="maximum_marks")
	private int totalMarks;
	@Column(name="batch_code")
	private String batchCode;
	
		
	@OneToMany(mappedBy="QPItemId",
            cascade = CascadeType.MERGE,orphanRemoval = true)
	private List<questionPaperItem> asitemIds=new ArrayList<questionPaperItem>();
	
	
	@OneToMany(mappedBy="qp",
            cascade = CascadeType.ALL,orphanRemoval = true)
	private List<instructions> asInstructions=new ArrayList<instructions>();

	
	@OneToOne
	@JoinColumn(name="course_master_id")
	private AuCourseMaster course=new AuCourseMaster();
	
	
	// --------------------------------------------------------------------------------
	@Transient
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Integer getQuestionPaperId() {
		return questionPaperId;
	}

	public void setQuestionPaperId(Integer questionPaperId) {
		this.questionPaperId = questionPaperId;
	}

	public int getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(int timeDuration) {
		this.timeDuration = timeDuration;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public List<questionPaperItem> getAsitemIds() {
		return asitemIds;
	}
	public void setAsitemIds(List<questionPaperItem> asitemIds) {
		this.asitemIds = asitemIds;
	}
	
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public List<String> getInst() {
		return inst;
	}
	public void setInst(List<String> inst) {
		this.inst = inst;
	}
	public List<instructions> getAsInstructions() {
		return asInstructions;
	}
	public void setAsInstructions(List<instructions> asInstructions) {
		this.asInstructions = asInstructions;
	}
	public AuCourseMaster getCourse() {
		return course;
	}
	public void setCourse(AuCourseMaster course) {
		this.course = course;
	}
	
}
