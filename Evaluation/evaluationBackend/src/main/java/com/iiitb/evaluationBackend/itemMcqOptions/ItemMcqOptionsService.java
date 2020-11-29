package com.iiitb.evaluationBackend.itemMcqOptions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemMcqOptionsService {
	
	@Autowired
	private ItemMcqOptionsRepository itemMcqOptionsRepository;
	
	public List<EvItemMcqOptions> getAllMcqOptionsForQpItem(int qpItemId) {
		return itemMcqOptionsRepository.findByEvQpItemQpItemId(qpItemId);
	}
	
	public void addItemMcqOptions(EvItemMcqOptions itemMcqOptions) {
		itemMcqOptionsRepository.save(itemMcqOptions);
	}
}
