package com.iiitb.assessmentBackEnd.itemTrueFalse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.assessmentBackEnd.itemMcqOptions.AsItemMcqOptions;

@Service
public class ItemTrueFalseService {
	@Autowired
	private ItemTrueFalseRepository itemTrueFalseRepository;
	
	public void addItemTrueFalse(AsItemTrueFalse itemTrueFalse) {
		itemTrueFalseRepository.save(itemTrueFalse);
	}
}


