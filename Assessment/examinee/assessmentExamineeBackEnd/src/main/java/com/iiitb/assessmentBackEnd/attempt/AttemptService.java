package com.iiitb.assessmentBackEnd.attempt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptService {
	
	@Autowired
	private AttemptRepository attemptRepository;
	
	public AsAttempt addAttempt(int examineeId, int batchId, AsAttempt attempt) {
		AsAttempt lastAttemptRow = getLastAttemptRow();
		attemptRepository.save(attempt);
//		AsAttempt currectAttemptOfExamineeBatch = getLastAttemptForExamineeIdAndBatchId(examineeId,batchId);
//		System.out.println("lastAttemptOfExamineeBatch = " + lastAttemptOfExamineeBatch.getAttemptId());
//		System.out.println("lastButoneAttempt = " + lastAttemptRow);
		return lastAttemptRow;
	}
	
	public Optional<AsAttempt> getAttempt(int attemptId) {
		return attemptRepository.findById(attemptId);
	}
	
	public AsAttempt getLastAttemptForExamineeIdAndBatchId(int examineeId, int batchId) {
		return attemptRepository.findTopByAsExamineeBatchExamineeBatchIdExamineeIdAndAsExamineeBatchExamineeBatchIdBatchIdOrderByAttemptNumberDesc(examineeId, batchId);
	}
	
	public AsAttempt getLastAttemptRow() {
		return attemptRepository.findTopByOrderByAttemptIdDesc();
	}

	public void updateAttempt(int examineeId, int batchId, AsAttempt attempt) {
		AsAttempt highestAttempt = getLastAttemptForExamineeIdAndBatchId(examineeId, batchId);
		highestAttempt.setAttemptEndTime(attempt.getAttemptEndTime());
		highestAttempt.setAttemptStatus(attempt.getAttemptStatus());
		attemptRepository.save(highestAttempt);
	}
}
