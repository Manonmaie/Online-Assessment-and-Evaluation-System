package com.urest.v1.authoring_module.questionPaper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.urest.v1.authoring_module.instructions.instructions;
import com.urest.v1.authoring_module.instructions.instructionsRepository;
import com.urest.v1.authoring_module.item.Item;
import com.urest.v1.authoring_module.questionPaperItem.questionPaperItem;
import com.urest.v1.authoring_module.questionPaperItem.questionPaperItemRepository;

@Service
public class questionPaperService {
	@Autowired
	private questionPaperRepository qpRepository;
	@Autowired
	private questionPaperItemRepository qpItemRepository;
	@Autowired
	private instructionsRepository inRepository;
	
	public List<questionPaper> getAllQp(){
		List<questionPaper> qpList = new ArrayList<>();
		qpRepository.findAll()
		.forEach(qpList::add);
		return qpList;
	}
	
	public questionPaper createQP(questionPaper q) {	
		System.out.println("create qp");
		questionPaper qp=new questionPaper(q.getTimeDuration(),q.getTotalMarks(),q.getCourse(),q.getBatchCode());
		qpRepository.save(qp);
		ArrayList<Item> items=(ArrayList<Item>) q.getItems();
		ArrayList<String> inst=(ArrayList<String>) q.getInst();
		for(int i=0;i<items.size();i++)
		{
			questionPaperItem qpItem =new questionPaperItem();
			qpItem.setItem(items.get(i));
			qpItem.setQPItemId(qp);
			qp.getAsitemIds().add(qpItemRepository.save(qpItem));
		}
		
		for(int i=0;i<inst.size();i++)
		{
			instructions in =new instructions(inst.get(i));
			in.setQp(qp);
			qp.getAsInstructions().add(inRepository.save(in));
		}
		return qp;	
	}
}
