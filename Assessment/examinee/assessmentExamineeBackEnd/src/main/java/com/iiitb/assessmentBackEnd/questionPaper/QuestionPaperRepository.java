package com.iiitb.assessmentBackEnd.questionPaper;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QuestionPaperRepository extends CrudRepository<AsQuestionPaper, Integer> {
	
//	@Query(value = "select as_question_paper.qp_id, as_question_paper.qp_code, as_question_paper.maximum_marks, as_question_paper.duration, as_batch.batch_start_time, as_batch.batch_end_time, as_course_master.course_name, as_batch_course.qp_status from (((as_batch inner join as_batch_course on as_batch.batch_id = as_batch_course.batch_id) inner join as_course_master on as_batch_course.course_master_id = as_course_master.course_master_id) inner join as_question_paper on as_batch_course.batch_course_id = as_question_paper.batch_course_id) where as_batch.batch_start_time between ?1 and ?2", 
//			nativeQuery = true)
//	@Query(value = "select as_question_paper.qp_id, as_examinee.examinee_name, as_batch.batch_start_time, as_batch.batch_end_time, as_batch.qp_status, as_course_master.course_name, as_question_paper.maximum_marks, as_question_paper.duration from (((as_examinee inner join as_examinee_batch on as_examinee.examinee_id = as_examinee_batch.examinee_id) inner join as_batch on as_examinee_batch.batch_id = as_batch.batch_id) inner join as_course_master on as_batch.course_master_id=as_course_master.course_master_id) inner join as_question_paper on as_batch.batch_id=as_question_paper.batch_id where as_examinee.examinee_id = ?1", 
//			nativeQuery = true)
//	List<AsQuestionPaperBatchCourse> findAllQuestionPaperNative(int examineeId);
	
	List<AsQuestionPaper> findByAsBatchAsExamineeBatchListExamineeExamineeId(int examineeId);
	
}
