package com.iiitb.assessmentBackEnd.attempt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AttemptController {
	
	@Autowired
	private AttemptService attemptService;
	
	@RequestMapping(method=RequestMethod.POST, value="/examinee/{examineeId}/batch/{batchId}/attempt")
	@ResponseBody
	public ResponseEntity<AsAttempt> addAttempt(@RequestBody AsAttempt attempt, @PathVariable int examineeId, @PathVariable int batchId) {
//		ExamineeBatchKey examineeBatchKey = new ExamineeBatchKey(examineeId, batchId);
//		AsExamineeBatch asExamineeBatch = new AsExamineeBatch(examineeBatchKey,null,null,"NOT_STARTED",null,null);
//		asExamineeBatch.setExamineeBatchId(examineeBatchKey);
//		attempt.setAsExamineeBatch(asExamineeBatch);
		return new ResponseEntity<AsAttempt>(attemptService.addAttempt(examineeId, batchId, attempt),HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/response/setResponse", headers="Content-Type=application/json", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<AsResponse> addResponse(@RequestBody AsResponse response) {
//        return new ResponseEntity<AsResponse>(responseService.addResponseAndResponseMcq(response),HttpStatus.OK);
//
//    }
	
	@RequestMapping("/examinee/{examineeId}/batch/{batchId}/attempt/{attemptId}")
	public Optional<AsAttempt> getAttempt(@PathVariable int attemptId) {
		return attemptService.getAttempt(attemptId);
	}
	
	@RequestMapping("/examinee/{examineeId}/batch/{batchId}/attempt")
	public AsAttempt getLastAttemptForExamineeIdAndBatchId(@PathVariable int examineeId, @PathVariable int batchId) {
		return attemptService.getLastAttemptForExamineeIdAndBatchId(examineeId,batchId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/examinee/{examineeId}/batch/{batchId}/attempt")
	public void updateAttempt(@PathVariable int examineeId, @PathVariable int batchId,@RequestBody AsAttempt attempt) {
		attemptService.updateAttempt(examineeId, batchId, attempt);
	}
}
