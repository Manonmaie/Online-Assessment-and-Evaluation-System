package com.urest.v1.authoring_module.apack;

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

@Entity
@Table(name = "out_apack_header")
public class Apack {
	@Id 
	@Column(name = "apack_header_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apack_header_id;
	
	@Column(name = "apack_desc")
	private String apack_desc;
	
	@Column(name = "created_on")
	private LocalDateTime created_on;
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name = "apack_status")
	private String apack_status;
	
	@Column(name = "apack_sent_on")
	private LocalDateTime apack_sent_on;
	
	@Column(name = "apack_path")
	private String apack_path;
	
//	@OneToMany(mappedBy = "apack_header")
//	@JsonIgnore
//	private List<Apack1> apack1List;
	
	public Apack() {
		super();
	}

	public int getApack_header_id() {
		return apack_header_id;
	}

	public void setApack_header_id(int apack_header_id) {
		this.apack_header_id = apack_header_id;
	}

	public String getApack_desc() {
		return apack_desc;
	}

	public void setApack_desc(String apack_desc) {
		this.apack_desc = apack_desc;
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

	public String getApack_status() {
		return apack_status;
	}

	public void setApack_status(String apack_status) {
		this.apack_status = apack_status;
	}

	public LocalDateTime getApack_sent_on() {
		return apack_sent_on;
	}

	public void setApack_sent_on(LocalDateTime apack_sent_on) {
		this.apack_sent_on = apack_sent_on;
	}

	public String getApack_path() {
		return apack_path;
	}

	public void setApack_path(String apack_path) {
		this.apack_path = apack_path;
	}
	
}
