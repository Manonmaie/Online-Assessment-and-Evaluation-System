package com.iiitb.evaluationBackend.itemMcqOptions;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ItemMcqOptionsRepository extends CrudRepository<EvItemMcqOptions, Integer> {
	
	public List<EvItemMcqOptions> findByEvQpItemQpItemId(int qpItemId);
}
