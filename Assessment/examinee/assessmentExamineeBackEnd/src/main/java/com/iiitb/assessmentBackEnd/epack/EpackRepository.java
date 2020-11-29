package com.iiitb.assessmentBackEnd.epack;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EpackRepository extends CrudRepository<Epack, Integer>{
	
	@Query(value="SELECT DISTINCT course_master_id, course_code, course_name FROM epack1", nativeQuery=true)
	public List<Object[]> fetchCourseMasterdata();
	
	@Query(value="SELECT DISTINCT examdrive_id, examdrive_code, examdrive_name, course_master_id FROM epack1", nativeQuery=true)
	public List<Object[]> fetchExamDrivedata();
	
	@Query(value="SELECT DISTINCT center_id, center_code, center_name FROM epack1", nativeQuery=true)
	public List<Object[]> fetchCenterData();
	
	@Query(value="SELECT DISTINCT qp_id, batch_id, maximum_marks, duration from epack1", nativeQuery=true)
	public List<Object[]> fetchQuestionPaperData();
	
	@Query(value="SELECT DISTINCT batch_id, batch_code, batch_start_time, batch_end_time, center_id, examdrive_id, qp_id FROM epack1", nativeQuery=true)
	public List<Object[]> fetchBatchData();
	
	@Query(value="SELECT DISTINCT qp_item_id, item_text, item_marks, item_type, cognitive_level, qp_id FROM epack2", nativeQuery=true)
	public List<Object[]> fetchQpItemData();
	
	@Query(value="SELECT DISTINCT qp_item_id, item_option_id, option_text FROM epack3", nativeQuery=true)
	public List<Object[]> fetchItemOptionsData();
	
	@Query(value="SELECT DISTINCT examinee_id, examinee_code, examinee_name, examinee_password, examinee_branch, examinee_email, examinee_college FROM epack4", nativeQuery=true)
	public List<Object[]> fetchExamineeData();
	
	@Query(value="SELECT DISTINCT examinee_batch_id, examinee_id, batch_id from epack4", nativeQuery=true)
	public List<Object[]> fetchExamineeBatchData();
}
