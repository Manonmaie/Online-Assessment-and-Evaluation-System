package com.iiitb.examAdminBackEnd.examineeBatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamineeBatchService {

	@Autowired
	ExamineeBatchRepository examineeBatchRepository;
	
	public void updateExamineeBatch(ExamineeBatchKey examineeBatchKey, ExamineeBatch examineeBatch) {
		examineeBatchRepository.save(examineeBatch);
	}
}
