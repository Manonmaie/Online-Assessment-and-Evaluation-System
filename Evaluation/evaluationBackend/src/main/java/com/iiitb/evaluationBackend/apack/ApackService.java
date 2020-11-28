package com.iiitb.evaluationBackend.apack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.qpItem.EvQpItem;

@Service
public class ApackService {
	@Autowired
	private ApackRepository apackRepository;
	
	public void addApack1(Apack apack) {
		apackRepository.save(apack);
	}
	
	public void addApackBulk(List<Apack> apacks) {
		apackRepository.saveAll(apacks);
	}
	
	public void deleteAll() {
		apackRepository.deleteAll();
	}
	
	public void apack2OriginalTables() {
		List<Object[]> qpItemObjects = apackRepository.fetchQpItemdata();
		for(int i = 0; i < qpItemObjects.size(); i++) {
			
			EvQpItem qpItem = new EvQpItem();
//			qpItem.setEvQuestionPaper(evQuestionPaper);
		}
	}
}
