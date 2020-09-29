package com.iiitb.evaluationBackend.questionPaper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.questionPaper.EvQuestionPaper;
import com.iiitb.evaluationBackend.questionPaper.QuestionPaperRepository;

@Service
public class QuestionPaperService {
	@Autowired
	private QuestionPaperRepository asQuestionPaperRepository;
	
	public List<EvQuestionPaper> getAllQps() {
		List<EvQuestionPaper> qpList = new ArrayList<>();
		asQuestionPaperRepository.findAll()
		.forEach(qpList::add);
		return qpList;
	}
}
