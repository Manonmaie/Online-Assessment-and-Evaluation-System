package com.iiitb.examAdminBackEnd.itemTrueFalse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.examAdminBackEnd.qp_item.QpItem;

@Entity
@Table(name = "ea_item_true_false")
public class ItemTrueFalse {
	@Id 
	@Column(name = "item_true_false_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_true_false_id;
	
	@ManyToOne
	@JoinColumn(name="qp_item_id")
//	@JsonIgnore
	private QpItem qpItem;

	public ItemTrueFalse() {
		super();
	}

	public ItemTrueFalse(int item_true_false_id) {
		super();
		this.item_true_false_id = item_true_false_id;
	}

	public int getItem_true_false_id() {
		return item_true_false_id;
	}

	public void setItem_true_false_id(int item_true_false_id) {
		this.item_true_false_id = item_true_false_id;
	}

	public QpItem getQpItem() {
		return qpItem;
	}

	public void setQpItem(QpItem qpItem) {
		this.qpItem = qpItem;
	}
}
