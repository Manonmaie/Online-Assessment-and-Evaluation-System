package com.iiitb.evaluationBackend.itemTrueFalse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemTrueFalseService {
	@Autowired
	private ItemTrueFalseRepository itemTrueFalseRepository;
	
	public void addItemTrueFalse(EvItemTrueFalse itemTrueFalse) {
		itemTrueFalseRepository.save(itemTrueFalse);
	}
}
