package com.iiitb.examAdminBackEnd.epack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EpackJoinRepository extends JpaRepository<Epack, Integer>{
	@Query(nativeQuery =true, value = "SELECT q.qp_id, q.maximum_marks, i.instruction_id, i.instruction_code, i.instruction_text, q.duration, b.batch_id, "
			+ "b.batch_code, b.batch_start_time, b.batch_end_time, c.center_id, c.center_code, c.center_name, e.examdrive_id, e.examdrive_code, e.examdrive_name, "
			+ "co.course_master_id, co.course_code, co.course_name FROM ea_center c INNER JOIN ea_batch b ON c.center_id = b.center_id INNER JOIN ea_question_paper q "
			+ "ON q.batch_id = b.batch_id LEFT JOIN ea_instruction i on i.qp_id = q.qp_id INNER JOIN ea_examdrive e on e.examdrive_id = b.examdrive_id INNER JOIN "
			+ "ea_course_master co ON e.course_master_id = co.course_master_id WHERE c.center_id = :course_id")
	List<Object[]> fetchEpack1Data(@Param("course_id") int course_id);
	
	@Query(nativeQuery = true, value = "SELECT i.qp_id, i.qp_item_id, i.item_text, i.item_marks, i.item_type, i.cognitive_level FROM ea_qp_item i WHERE i.qp_id = :qp_id")
	List<Object[]> fetchEpack2Data(@Param("qp_id") int qp_id);
	
	@Query(nativeQuery = true, value = "SELECT o.qp_item_id, o.item_mcq_id, o.mcq_option_text FROM ea_item_mcq_options o WHERE o.qp_item_id = :qp_item_id")
	List<Object[]> fetchEpack3McqData(@Param("qp_item_id") int qp_item_id);
	
	@Query(nativeQuery = true, value = "SELECT o.qp_item_id, o.item_true_false_id FROM ea_item_true_false o WHERE o.qp_item_id = :qp_item_id")
	List<Object[]> fetchEpack3TFData(@Param("qp_item_id") int qp_item_id);
	
	@Query(nativeQuery = true, value = "SELECT b.batch_id, eb.examinee_batch_id, e.examinee_id, e.examinee_code, e.examinee_name, e.examinee_password, e.examinee_branch, e.examinee_email, e.examinee_college "
			+ "FROM ea_batch b INNER JOIN ea_examinee_batch eb ON b.batch_id = eb.batch_id INNER JOIN ea_examinee e ON e.examinee_id = eb.examinee_id WHERE b.batch_id = :batch_id")
	List<Object[]> fetchEpack4Data(@Param("batch_id") int batch_id);
}
