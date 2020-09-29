package com.iiitb.evaluationBackend.questionPaper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.evaluationBackend.questionPaper.EvQuestionPaper;
import com.iiitb.evaluationBackend.questionPaper.QuestionPaperService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionPaperController {
	@Autowired
	private QuestionPaperService questionPaperService;

	
	@RequestMapping("/questionPaper")
	public List<EvQuestionPaper> getAllQpsOfExaminee() {
		return questionPaperService.getAllQps();
	}
}
