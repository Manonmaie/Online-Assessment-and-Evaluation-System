package com.iiitb.assessmentBackEnd.outRpackHeader;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.rpack1.Rpack1;

@Entity
public class OutRpackHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rpackHeaderId;
	private String rpackDesc, createdBy, rpackPath;
	private LocalDateTime createdOn, rpackSentOn;
	private enum rpackStatusList { CREATED, SENT};
	private String rpackStatus;
	@OneToMany(mappedBy = "rpack_header")
	@JsonIgnore
	private List<Rpack1> rpack1List;
	
	public OutRpackHeader() {
		
	}
	
	public OutRpackHeader(int rpackHeaderId, String rpackDesc, String createdBy, String rpackPath,
			LocalDateTime createdOn, LocalDateTime rpackSentOn, String rpackStatus) {
		super();
		this.rpackHeaderId = rpackHeaderId;
		this.rpackDesc = rpackDesc;
		this.createdBy = createdBy;
		this.rpackPath = rpackPath;
		this.createdOn = createdOn;
		this.rpackSentOn = rpackSentOn;
		this.rpackStatus = rpackStatus;
	}

	public int getRpackHeaderId() {
		return rpackHeaderId;
	}

	public void setRpackHeaderId(int rpackHeaderId) {
		this.rpackHeaderId = rpackHeaderId;
	}

	public String getRpackDesc() {
		return rpackDesc;
	}

	public void setRpackDesc(String rpackDesc) {
		this.rpackDesc = rpackDesc;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getRpackPath() {
		return rpackPath;
	}

	public void setRpackPath(String rpackPath) {
		this.rpackPath = rpackPath;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getRpackSentOn() {
		return rpackSentOn;
	}

	public void setRpackSentOn(LocalDateTime rpackSentOn) {
		this.rpackSentOn = rpackSentOn;
	}

	public String getRpackStatus() {
		return rpackStatus;
	}

	public void setRpackStatus(String rpackStatus) {
		this.rpackStatus = rpackStatus;
	}
}
