package com.iiitb.evaluationBackend.qpItem;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QpItemRepository extends CrudRepository<EvQpItem, Integer> {
	
	public List<EvQpItem> findByEvQuestionPaperQpId(int qpId);
}
