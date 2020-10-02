package com.iiitb.assessmentBackEnd.attempt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.assessmentBackEnd.examineeBatch.AsExamineeBatch;
import com.iiitb.assessmentBackEnd.examineeBatch.ExamineeBatchKey;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AttemptController {
	
	@Autowired
	private AttemptService attemptService;
	
	@RequestMapping(method=RequestMethod.POST, value="/examinee/{examineeId}/batch/{batchId}/attempt")
	public void addAttempt(@RequestBody AsAttempt attempt, @PathVariable int examineeId, @PathVariable int batchId) {
		ExamineeBatchKey examineeBatchKey = new ExamineeBatchKey(examineeId, batchId);
		AsExamineeBatch asExamineeBatch = new AsExamineeBatch(examineeBatchKey,null,null,"NOT_STARTED",null,null);
//		asExamineeBatch.setExamineeBatchId(examineeBatchKey);
		attempt.setAsExamineeBatch(asExamineeBatch);
		attemptService.addAttempt(attempt);
	}
	
	@RequestMapping("/examinee/{examineeId}/batch/{batchId}/attempt/{attemptId}")
	public Optional<AsAttempt> getAttempt(@PathVariable int attemptId) {
		return attemptService.getAttempt(attemptId);
	}
}
