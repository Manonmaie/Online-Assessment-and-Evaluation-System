package com.iiitb.assessmentBackEnd.questionPaper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.assessmentBackEnd.instruction.AsInstruction;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionPaperController {
	
	@Autowired
	private QuestionPaperService questionPaperService;

//	private LocalDateTime dt = LocalDateTime.now();
//	DateTimeFormatter formatdt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    
//	@RequestMapping("/questionPapers")
//	public List<AsQuestionPaperBatchCourse> getAllQps() {
//		return questionPaperService.getAllQps(this.dt.format(formatdt),this.dt.plusHours(1).format(formatdt));
//	}
	
	@RequestMapping("/examinee/{examineeId}/questionPapers")
	public List<AsQuestionPaper> getAllQpsOfExaminee(@PathVariable int examineeId) {
		return questionPaperService.getAllQps(examineeId);
	}
}
