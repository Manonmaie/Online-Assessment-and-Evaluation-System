package com.iiitb.evaluationBackend.qpItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QpItemService {
	
	@Autowired
	private QpItemRepository qpItemRepository;
	
	public List<EvQpItem> getAllQpItemsForQp(int qpId) {
		return qpItemRepository.findByEvQuestionPaperQpId(qpId);
	}

	public void addQpItem(EvQpItem qpItem) {
		qpItemRepository.save(qpItem);
	}
}

