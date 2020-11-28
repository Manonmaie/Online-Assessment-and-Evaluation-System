package com.iiitb.examAdminBackEnd.qp_item;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QpItemService {
	@Autowired
	private QpItemRepository qpItemRepository;
	
	public void addQpItem(QpItem qpItem) {
		qpItemRepository.save(qpItem);
	}
	
	public QpItem getQpItem(int id){
		return qpItemRepository.findById(id);
	}
	
	public void addQpItemBulk(List<QpItem> qpItem) {
		qpItemRepository.saveAll(qpItem);
	}
	
	public void deleteAll() {
		qpItemRepository.deleteAll();
	}
}
