package com.iiitb.assessmentBackEnd.qpItem;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QpItemRepository extends CrudRepository<AsQpItem, Integer> {
	
	public List<AsQpItem> findByAsQuestionPaperQpId(int qpId);
}
