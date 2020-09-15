package com.iiitb.assessmentBackEnd.questionPaper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionPaperService {
	
	@Autowired
	private QuestionPaperRepository asQuestionPaperRepository;
	
	private List<AsQuestionPaper> qps =  Arrays.asList(
			new AsQuestionPaper(1,"MAT_1",1,100,180),
			new AsQuestionPaper(2,"PHY_1",1,50,180),
			new AsQuestionPaper(3,"CHEM_1",1,25,180)
			);
	
	public List<AsQuestionPaper> getAllQps() {
		List<AsQuestionPaper> qpList = new ArrayList<>();
		asQuestionPaperRepository.findAll()
		.forEach(qpList::add);
		return qpList;
	}
}
