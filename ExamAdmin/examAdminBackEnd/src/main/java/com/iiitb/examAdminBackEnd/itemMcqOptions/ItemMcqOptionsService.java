package com.iiitb.examAdminBackEnd.itemMcqOptions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemMcqOptionsService {
	@Autowired
	private ItemMcqOptionsRepository itemMcqOptionsRepository;
	
	public void additemMcqOptions(ItemMcqOptions itemMcqOptions) {
		itemMcqOptionsRepository.save(itemMcqOptions);
	}
	
	public Optional<ItemMcqOptions> getitemMcqOptions(int id){
		return itemMcqOptionsRepository.findById(id);
	}
	
	public void additemMcqOptionsBulk(List<ItemMcqOptions> itemMcqOptions) {
		itemMcqOptionsRepository.saveAll(itemMcqOptions);
	}
	
	public void deleteAll() {
		itemMcqOptionsRepository.deleteAll();
	}
}
