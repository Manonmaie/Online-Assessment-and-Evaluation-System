package com.iiitb.assessmentBackEnd.questionPaper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionPaperController {
	
	@Autowired
	private QuestionPaperService questionPaperService;
	
	@RequestMapping("/questionPapers")
	public List<AsQuestionPaper> getAllQps() {
		return questionPaperService.getAllQps();
	}
}
