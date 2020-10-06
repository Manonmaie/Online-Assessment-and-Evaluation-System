package com.iiitb.assessmentBackEnd.attempt;

import org.springframework.data.repository.CrudRepository;

public interface AttemptRepository  extends CrudRepository<AsAttempt, Integer>  {
	
	AsAttempt findTopByAsExamineeBatchExamineeBatchIdExamineeIdAndAsExamineeBatchExamineeBatchIdBatchIdOrderByAttemptNumberDesc(int examineeId, int batchId);
	AsAttempt findTopByOrderByAttemptIdDesc();
}
