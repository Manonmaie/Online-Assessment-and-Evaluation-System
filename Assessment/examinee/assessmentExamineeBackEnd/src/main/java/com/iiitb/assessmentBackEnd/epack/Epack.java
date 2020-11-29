package com.iiitb.assessmentBackEnd.epack;

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
@Table(name = "out_epack_header")
public class Epack {
	@Id 
	@Column(name = "epack_header_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int epack_header_id;
	
	@Column(name = "epack_desc")
	private String epack_desc;
	
	@Column(name = "created_on")
	private LocalDateTime created_on;
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name = "epack_status")
	private String epack_status;
	
	@Column(name = "epack_sent_on")
	private LocalDateTime epack_sent_on;
	
	@Column(name = "epack_path")
	private String epack_path;
	
	@Column(name = "center_id")
	private int center_id;

	public Epack() {
		super();
	}

	public int getEpack_header_id() {
		return epack_header_id;
	}

	public void setEpack_header_id(int epack_header_id) {
		this.epack_header_id = epack_header_id;
	}

	public String getEpack_desc() {
		return epack_desc;
	}

	public void setEpack_desc(String epack_desc) {
		this.epack_desc = epack_desc;
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

	public String getEpack_status() {
		return epack_status;
	}

	public void setEpack_status(String epack_status) {
		this.epack_status = epack_status;
	}

	public LocalDateTime getEpack_sent_on() {
		return epack_sent_on;
	}

	public void setEpack_sent_on(LocalDateTime epack_sent_on) {
		this.epack_sent_on = epack_sent_on;
	}

	public String getEpack_path() {
		return epack_path;
	}

	public void setEpack_path(String epack_path) {
		this.epack_path = epack_path;
	}

	public int getCenter_id() {
		return center_id;
	}

	public void setCenter_id(int center_id) {
		this.center_id = center_id;
	}
}
