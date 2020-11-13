package com.urest.v1.authoring_module.questionPaper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.urest.v1.authoring_module.questionPaperItem.questionPaperItem;
import com.urest.v1.authoring_module.questionPaperItem.questionPaperItemRepository;

@Service
public class questionPaperService {
	@Autowired
	private questionPaperRepository qpRepository;
	@Autowired
	private questionPaperItemRepository qpItemRepository;
	
	public List<questionPaper> getAllQp(){
		List<questionPaper> qpList = new ArrayList<>();
		qpRepository.findAll()
		.forEach(qpList::add);
		return qpList;
	}
	
	public questionPaper createQP(questionPaper q) {	
		questionPaper qp=new questionPaper(q.getTimeDuration(),q.getTotalMarks(),q.getCourse(),q.getBatchCode());
		qpRepository.save(qp);
		ArrayList<questionPaperItem> qpItem=(ArrayList<questionPaperItem>) q.getAsitemIds();
		for(int i=0;i<qpItem.size();i++)
		{
			questionPaperItem t =new questionPaperItem();
			t.setItem(qpItem.get(i).getItem());
			t.setQPItemId(qp);
			qp.getAsitemIds().add(qpItemRepository.save(t));
		}
		return qp;	
	}
}
