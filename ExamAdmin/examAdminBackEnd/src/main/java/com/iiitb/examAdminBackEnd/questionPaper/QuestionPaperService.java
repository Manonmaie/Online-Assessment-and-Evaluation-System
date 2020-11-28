package com.iiitb.examAdminBackEnd.questionPaper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionPaperService {
	@Autowired
	private QuestionPaperRepository questionPaperRepository;
	
	public void addQuestionPaper(QuestionPaper questionPaper) {
		questionPaperRepository.save(questionPaper);
	}
	
	public Optional<QuestionPaper> getQuestionPaper(int id){
		return questionPaperRepository.findById(id);
	}
	
	public void addQuestionPaperBulk(List<QuestionPaper> questionPaper) {
		questionPaperRepository.saveAll(questionPaper);
	}
	
	public void deleteAll() {
		questionPaperRepository.deleteAll();
	}
}
