package com.iiitb.assessmentBackEnd.qpItem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QpItemService {
	
	@Autowired
	private QpItemRepository qpItemRepository;
	
	public List<AsQpItem> getAllQpItemsForQp(int qpId) {
		return qpItemRepository.findByAsQuestionPaperQpId(qpId);
	}

}
