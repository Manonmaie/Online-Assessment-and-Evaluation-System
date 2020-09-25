package com.iiitb.assessmentBackEnd.itemMcqOptions;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ItemMcqOptionsRepository extends CrudRepository<AsItemMcqOptions, Integer> {
	
	public List<AsItemMcqOptions> findByAsQpItemQpItemId(int qpItemId);
}
