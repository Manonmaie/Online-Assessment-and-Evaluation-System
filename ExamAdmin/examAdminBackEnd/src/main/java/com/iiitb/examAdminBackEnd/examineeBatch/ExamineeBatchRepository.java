package com.iiitb.examAdminBackEnd.examineeBatch;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ExamineeBatchRepository extends CrudRepository<ExamineeBatch, ExamineeBatchKey> {
	public List<ExamineeBatch> findByBatchBatchId(int id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM ea_examinee_batch WHERE examinee_batch_id = :examinee_batch_id")
	public Optional<ExamineeBatch> findByExamineeBatchId(@Param("examinee_batch_id") int examinee_batch_id);
}
