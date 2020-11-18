package com.urest.v1.authoring_module.qpack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.urest.v1.authoring_module.qpack1.Qpack1;
import com.urest.v1.authoring_module.qpack2.Qpack2;


public interface QpackJoinRepository extends JpaRepository<Qpack, Integer>{
	@Query(nativeQuery =true, value = "SELECT q.qp_id, q.maximum_marks, i.instruction_id, i.instruction_text, q.duration, q.course_code, q.batch_code FROM "
			+ "au_question_paper q LEFT JOIN au_instruction i ON q.qp_id = i.qp_id")
	List<Object[]> fetchQpack1Data();
	
	@Query(nativeQuery = true, value = "SELECT c.course_master_id, c.course_code, c.course_name FROM au_course_master c WHERE c.course_code = :course_code")
	List<Object[]> getCourseByCode(@Param("course_code") String course_code);
	
	@Query(nativeQuery = true, value = "SELECT q.qp_id, i.item_id, i.item_text, i.marks, i.item_type, i.cognitive_level FROM au_item i INNER JOIN au_qp_item q ON q.item_id = i.item_id WHERE q.qp_id = :qp_id")
	List<Object[]> fetchQpack2Data(@Param("qp_id") int qp_id);
	
	@Query(nativeQuery = true, value = "SELECT i.item_id, o.item_mcq_id, o.mcq_option_text FROM au_qp_item i INNER JOIN au_item_mcq_options o ON i.item_id = o.item_id")
	List<Object[]> fetchQpack3McqData();
	
	@Query(nativeQuery = true, value = "SELECT i.item_id, o.item_true_false_id FROM au_qp_item i INNER JOIN au_item_true_false o ON i.item_id = o.item_id")
	List<Object[]> fetchQpack3TFData();
	
}
