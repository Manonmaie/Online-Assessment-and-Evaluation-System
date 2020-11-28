package com.iiitb.examAdminBackEnd.examineeBatch;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExamineeBatchRepository extends CrudRepository<ExamineeBatch, ExamineeBatchKey> {
	public List<ExamineeBatch> findByBatchBatchId(int id);
}
