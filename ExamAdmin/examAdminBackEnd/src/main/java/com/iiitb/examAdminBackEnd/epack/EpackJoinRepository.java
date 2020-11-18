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
}
