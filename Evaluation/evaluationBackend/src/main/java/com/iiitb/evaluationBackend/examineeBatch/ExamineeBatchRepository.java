package com.iiitb.evaluationBackend.examineeBatch;
import org.springframework.data.repository.CrudRepository;

import com.iiitb.evaluationBackend.examineeBatch.EvExamineeBatch;

public interface ExamineeBatchRepository extends CrudRepository<EvExamineeBatch, Integer> {
	
	EvExamineeBatch findByExamineeBatchId(int examineeBatchId);
	
}
