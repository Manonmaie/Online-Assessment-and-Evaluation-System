package com.iiitb.assessmentBackEnd.rpack;

import java.util.List;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.rpack1.Rpack1;

@Entity
@Table(name = "out_rpack_header")
public class Rpack {
	@Id 
	@Column(name = "rpack_header_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rpack_header_id;
	
	@Column(name = "rpack_desc")
	private String rpack_desc;
	
	@Column(name = "created_on")
	private LocalDateTime created_on;
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name = "rpack_status")
	private String rpack_status;
	
	@Column(name = "rpack_sent_on")
	private LocalDateTime rpack_sent_on;
	
	@Column(name = "rpack_path")
	private String rpack_path;
	
	@OneToMany(mappedBy = "rpack_header")
	@JsonIgnore
	private List<Rpack1> rpack1List;
	
	public Rpack() {
		super();
	}

	public int getRpack_header_id() {
		return rpack_header_id;
	}

	public void setRpack_header_id(int rpack_header_id) {
		this.rpack_header_id = rpack_header_id;
	}

	public String getRpack_desc() {
		return rpack_desc;
	}

	public void setRpack_desc(String rpack_desc) {
		this.rpack_desc = rpack_desc;
	}

	public LocalDateTime getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getRpack_status() {
		return rpack_status;
	}

	public void setRpack_status(String rpack_status) {
		this.rpack_status = rpack_status;
	}

	public LocalDateTime getRpack_sent_on() {
		return rpack_sent_on;
	}

	public void setRpack_sent_on(LocalDateTime rpack_sent_on) {
		this.rpack_sent_on = rpack_sent_on;
	}

	public String getRpack_path() {
		return rpack_path;
	}

	public void setRpack_path(String rpack_path) {
		this.rpack_path = rpack_path;
	}
}
