package com.iiitb.examAdminBackEnd.qpack;

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
@Table(name = "out_qpack_header")
public class Qpack {
	@Id 
	@Column(name = "qpack_header_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qpack_header_id;
	
	@Column(name = "qpack_desc")
	private String qpack_desc;
	
	@Column(name = "created_on")
	private LocalDateTime created_on;
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name = "qpack_status")
	private String qpack_status;
	
	@Column(name = "qpack_sent_on")
	private LocalDateTime qpack_sent_on;
	
	@Column(name = "qpack_path")
	private String qpack_path;

	public Qpack() {
		super();
	}

	public Qpack(String qpack_desc, LocalDateTime created_on, String created_by, String qpack_status,
			LocalDateTime qpack_sent_on, String qpack_path) {
		super();
		this.qpack_desc = qpack_desc;
		this.created_on = created_on;
		this.created_by = created_by;
		this.qpack_status = qpack_status;
		this.qpack_sent_on = qpack_sent_on;
		this.qpack_path = qpack_path;
	}

	public int getQpack_header_id() {
		return qpack_header_id;
	}

	public void setQpack_header_id(int qpack_header_id) {
		this.qpack_header_id = qpack_header_id;
	}

	public String getQpack_desc() {
		return qpack_desc;
	}

	public void setQpack_desc(String qpack_desc) {
		this.qpack_desc = qpack_desc;
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

	public String getQpack_status() {
		return qpack_status;
	}

	public void setQpack_status(String qpack_status) {
		this.qpack_status = qpack_status;
	}

	public LocalDateTime getQpack_sent_on() {
		return qpack_sent_on;
	}

	public void setQpack_sent_on(LocalDateTime qpack_sent_on) {
		this.qpack_sent_on = qpack_sent_on;
	}

	public String getQpack_path() {
		return qpack_path;
	}

	public void setQpack_path(String qpack_path) {
		this.qpack_path = qpack_path;
	}
}
