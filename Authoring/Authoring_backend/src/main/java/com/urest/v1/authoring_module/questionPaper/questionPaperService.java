package com.urest.v1.authoring_module.questionPaper;


import java.util.ArrayList;

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
	
	public questionPaper createQP(questionPaper q) {	
		System.out.println("moomzz");
		questionPaper qp=new questionPaper(q.getTimeDuration(),q.getTotalMarks(),q.getCourse(),q.getInstructions());
		qpRepository.save(qp);
		ArrayList<questionPaperItem> qpItem=(ArrayList<questionPaperItem>) q.getAsitemIds();
		for(int i=0;i<qpItem.size();i++)
		{
			questionPaperItem t =new questionPaperItem(qpItem.get(i).getItemId());
			t.setQPItemId(qp);
			qp.getAsitemIds().add(qpItemRepository.save(t));
		}
		return q;	
	}
}
