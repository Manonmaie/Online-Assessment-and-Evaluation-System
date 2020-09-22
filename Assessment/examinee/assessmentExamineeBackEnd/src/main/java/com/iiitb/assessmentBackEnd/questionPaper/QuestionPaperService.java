package com.iiitb.assessmentBackEnd.questionPaper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionPaperService {
	
	@Autowired
	private QuestionPaperRepository asQuestionPaperRepository;
	
	public List<AsQuestionPaperBatchCourse> getAllQps(String dt1, String dt2) {
		List<AsQuestionPaperBatchCourse> qpList = new ArrayList<>();
		asQuestionPaperRepository.findAllQuestionPaperNative(dt1,dt2)
		.forEach(qpList::add);
		return qpList;
	}
}
