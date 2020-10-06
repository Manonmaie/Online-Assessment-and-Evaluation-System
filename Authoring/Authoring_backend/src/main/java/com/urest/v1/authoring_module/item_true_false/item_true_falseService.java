package com.urest.v1.authoring_module.item_true_false;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urest.v1.authoring_module.item.Item;
import com.urest.v1.authoring_module.item.ItemRepository;


@Service
public class item_true_falseService {
//	@Autowired
//	private item_true_falseRepository item_true_falseRepository;
//	
////	private List<Item> items =  Arrays.asList(
////			new Item(1, 100, "Test", "REMEMBER","PENDING","ACTIVE",0),
////			new Item(2, 100, "Test","UNDERSTAND","PENDING","ACTIVE",0),
////			new Item(3, 100, "Test","ANALYZE","PENDING","ACTIVE",0)
////		);
//	
//	public List<item_true_false> getAllItems() {
//		List<item_true_false> itemList = new ArrayList<>();
//		item_true_falseRepository.findAll()
//		.forEach(itemList::add);
//		return itemList;
//	}
//	
//	public Optional<item_true_false> getItem(Integer id) {
//		Optional<item_true_false> item = item_true_falseRepository.findById(id);
//		if (!item.isPresent())
//			throw new RuntimeException("Item not found id-" + id);
//		return item;
//	}
//	
//	public item_true_false createItem(item_true_false question) {
//		item_true_false item = new item_true_false();
////		item.setQuestion(question.getQuestion());
////		item.setMarks(question.getMarks());
////		item.setCg_lvl(question.getCg_lvl());
////		item.setReview_status("PENDING");
////		item.setItem_use_count(0);
////		item.setItem_status("ACTIVE");
////		item.setDiff_lvl(question.getDiff_lvl());
//		item.setFalseMarks(question.getFalseMarks());
//		item.setTrueMarks(question.getTrueMarks());
//		item.setId(question.getId());
//		item.setItem(question.getItem());;
//		item_true_falseRepository.save(item);
//
//		return item;
//	}
}
