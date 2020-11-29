package com.iiitb.assessmentBackEnd.examineeBatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamineeBatchService {
	
	@Autowired
	private ExamineeBatchRepository examineeBatchRepository;
	
	public AsExamineeBatch getExamineeBatchFromExamineeAndBatchIds(int examineeId, int batchId) {
		ExamineeBatchKey examineeBatchKey = new ExamineeBatchKey(examineeId, batchId); 
		return examineeBatchRepository.findByExamineeBatchId(examineeBatchKey);
	}

	public void updateExamineeBatch(AsExamineeBatch examineeBatch) {
		examineeBatchRepository.save(examineeBatch);
	}

	public void addExamineeBatch(AsExamineeBatch examineeBatch) {
		examineeBatchRepository.save(examineeBatch);
	}
}
