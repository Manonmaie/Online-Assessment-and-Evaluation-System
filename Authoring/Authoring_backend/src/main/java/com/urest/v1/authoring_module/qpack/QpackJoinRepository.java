package com.urest.v1.authoring_module.qpack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.urest.v1.authoring_module.qpack1.Qpack1;
//import com.urest.v1.authoring_module.qpack2.Qpack2;


public interface QpackJoinRepository extends JpaRepository<Qpack1, Integer>{
	@Query(nativeQuery =true, value = "SELECT q.qp_id, q.maximum_marks, i.instruction_id, i.instruction_text, q.duration, q.course_code, q.batch_code FROM "
			+ "au_question_paper q INNER JOIN au_instruction i ON q.qp_id = i.qp_id")
	List<Object[]> fetchQpack1Data();
	
	@Query(nativeQuery = true, value = "SELECT c.course_master_id, c.course_code, c.course_name FROM au_course_master c WHERE c.course_code = :course_code")
	Object[] getCourseByCode(@Param("course_code") String course_code);
//	@Query("SELECT new Qpack2(q.question_paper_id, i.itemId, i.itemText, i.marks, i.itemType, i.cgLvl) FROM Item i INNER JOIN questionPaperItem q on q.itemId = i.itemId")
//	List<Qpack2> fetchQpack2Data();
	
}
