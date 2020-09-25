package com.iiitb.assessmentBackEnd.itemMcqOptions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemMcqOptionsService {
	
	@Autowired
	private ItemMcqOptionsRepository itemMcqOptionsRepository;
	
	public List<AsItemMcqOptions> getAllMcqOptionsForQpItem(int qpItemId) {
		return itemMcqOptionsRepository.findByAsQpItemQpItemId(qpItemId);
	}

}
