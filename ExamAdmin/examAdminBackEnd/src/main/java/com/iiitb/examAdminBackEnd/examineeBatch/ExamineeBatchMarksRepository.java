package com.iiitb.examAdminBackEnd.examineeBatch;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExamineeBatchMarksRepository extends CrudRepository<ExamineeBatchMarks, ExamineeBatchKey>{
	public List<ExamineeBatchMarks> findByBatchExamdriveExamdriveId(int id);
	public List<ExamineeBatchMarks> findByExamineeExamineeId(int id);
}
