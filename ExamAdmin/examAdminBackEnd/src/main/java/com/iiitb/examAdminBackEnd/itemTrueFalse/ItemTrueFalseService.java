package com.iiitb.examAdminBackEnd.itemTrueFalse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemTrueFalseService {
	@Autowired
	private ItemTrueFalseRepository itemTrueFalseRepository;
	
	public void addItemTrueFalse(ItemTrueFalse itemTrueFalse) {
		itemTrueFalseRepository.save(itemTrueFalse);
	}
	
	public Optional<ItemTrueFalse> getItemTrueFalse(int id){
		return itemTrueFalseRepository.findById(id);
	}
	
	public void addItemTrueFalseBulk(List<ItemTrueFalse> itemTrueFalse) {
		itemTrueFalseRepository.saveAll(itemTrueFalse);
	}
	
	public void deleteAll() {
		itemTrueFalseRepository.deleteAll();
	}
}
