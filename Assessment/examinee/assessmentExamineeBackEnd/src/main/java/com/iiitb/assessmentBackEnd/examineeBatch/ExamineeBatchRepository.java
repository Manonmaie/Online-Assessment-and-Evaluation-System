package com.iiitb.assessmentBackEnd.examineeBatch;

import org.springframework.data.repository.CrudRepository;

public interface ExamineeBatchRepository extends CrudRepository<AsExamineeBatch, Integer>{
	
	public AsExamineeBatch findByExamineeBatchId(ExamineeBatchKey examineeBatchKey);

}
