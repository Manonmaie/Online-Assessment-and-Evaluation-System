package com.iiitb.assessmentBackEnd.questionPaper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

	private LocalDateTime dt = LocalDateTime.now();
	
	DateTimeFormatter formatdt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
	@RequestMapping("/questionPapers")
	public List<AsQuestionPaperBatchCourse> getAllQps() {
		return questionPaperService.getAllQps(this.dt.format(formatdt),this.dt.plusHours(1).format(formatdt));
	}
}
