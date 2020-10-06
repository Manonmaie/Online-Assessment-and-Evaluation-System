package com.urest.v1.authoring_module.item_true_false;

import javax.persistence.*;

import com.urest.v1.authoring_module.item.Item;

public class item_true_false {}

//@Entity
//@Table(name="item_true_false")
//public class item_true_false {
//	@Id
//    @GeneratedValue
//    @Column(name = "item_true_false_id")
//	private Integer  id;
//	@Column(name = "true_marks")
//	private String trueMarks;
//	@Column(name = "false_marks")
//	private String falseMarks;
//	@Column(name = "item_id")
//	private Integer item_id;
//	
//	@OneToOne(cascade = CascadeType.ALL)// cascade changes in this are effected to the child class
//    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
//    private Item item;
//	
//	item_true_false(String trueMarks,String falseMarks,int id,int itemid,Integer marks, String question, String cg_lvl,String review_status,String item_status,Integer item_use_count,String diff_lvl){
//		this.falseMarks=falseMarks;
//		this.trueMarks=trueMarks;
//		this.id=id;
//		this.item.setId(itemid);
//		this.item.setCg_lvl(cg_lvl);
//		this.item.setItem_use_count(item_use_count);
//		this.item.setItem_status(item_status);
//		this.item.setMarks(marks);
//		this.item.setQuestion(question);
//		this.item.setReview_status(review_status);
//	}
//	
//	public Integer getId() {
//		return id;
//	}
//
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//
//	public String getTrueMarks() {
//		return trueMarks;
//	}
//
//
//	public void setTrueMarks(String trueMarks) {
//		this.trueMarks = trueMarks;
//	}
//
//
//	public String getFalseMarks() {
//		return falseMarks;
//	}
//
//
//	public void setFalseMarks(String falseMarks) {
//		this.falseMarks = falseMarks;
//	}
//
//
//	public Item getItem() {
//		return item;
//	}
//
//
//	public void setItem(Item item) {
//		this.item = item;
//	}
//
//	
//	public item_true_false() {
//		
//	}

//}
