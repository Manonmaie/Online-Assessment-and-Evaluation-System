package com.iiitb.evaluationBackend.mpack;

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
import com.iiitb.evaluationBackend.mpack1.Mpack1;

@Entity
@Table(name = "out_mpack_header")
public class Mpack {
	@Id 
	@Column(name = "mpack_header_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mpack_header_id;
	
	@Column(name = "mpack_desc")
	private String mpack_desc;
	
	@Column(name = "created_on")
	private LocalDateTime created_on;
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name = "mpack_status")
	private String mpack_status;
	
	@Column(name = "mpack_sent_on")
	private LocalDateTime mpack_sent_on;
	
	@Column(name = "mpack_path")
	private String mpack_path;

	
	@OneToMany(mappedBy = "mpack_header")
	@JsonIgnore
	private List<Mpack1> mpack1List;

	public Mpack() {
		super();
	}


	public int getMpack_header_id() {
		return mpack_header_id;
	}


	public void setMpack_header_id(int mpack_header_id) {
		this.mpack_header_id = mpack_header_id;
	}


	public String getMpack_desc() {
		return mpack_desc;
	}


	public void setMpack_desc(String mpack_desc) {
		this.mpack_desc = mpack_desc;
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


	public String getMpack_status() {
		return mpack_status;
	}


	public void setMpack_status(String mpack_status) {
		this.mpack_status = mpack_status;
	}


	public LocalDateTime getMpack_sent_on() {
		return mpack_sent_on;
	}


	public void setMpack_sent_on(LocalDateTime mpack_sent_on) {
		this.mpack_sent_on = mpack_sent_on;
	}


	public String getMpack_path() {
		return mpack_path;
	}


	public void setMpack_path(String mpack_path) {
		this.mpack_path = mpack_path;
	}
	
	
	
}
