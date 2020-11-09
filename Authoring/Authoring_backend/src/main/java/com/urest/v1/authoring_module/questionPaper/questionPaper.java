package com.urest.v1.authoring_module.questionPaper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.urest.v1.authoring_module.TF.TF;
import com.urest.v1.authoring_module.questionPaperItem.questionPaperItem;

@Entity // This tells Hibernate to make a table out of this class

@Table(name = "question_Paper")
public class questionPaper {
	questionPaper(){
		
	}
	questionPaper(int timeDuration,int totalMarks,String course,String Instructions){
		this.timeDuration=timeDuration;
		this.totalMarks=totalMarks;
		this.course=course;
		this.instructions=Instructions;
	}
	
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="question_paper_id", updatable = false, nullable = false)
	private Integer questionPaperId;
	
	@Column(name="time_duration")
	private int timeDuration;
	@Column(name="total_marks")
	private int totalMarks;
	private String course;
	private String instructions;
	
	@OneToMany(mappedBy="QPItemId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,orphanRemoval = true)
	private List<questionPaperItem> asitemIds=new ArrayList<questionPaperItem>();
		
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	public List<questionPaperItem> getAsitemIds() {
		return asitemIds;
	}
	public void setAsitemIds(List<questionPaperItem> asitemIds) {
		this.asitemIds = asitemIds;
	}
	


	
}
