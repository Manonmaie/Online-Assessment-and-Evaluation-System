package com.iiitb.examAdminBackEnd.epack;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iiitb.examAdminBackEnd.epack1.Epack1;

public interface EpackJoinRepository extends JpaRepository<Epack1, Integer>{
	@Query("SELECT new Epack1(q.qp_id, q.qp_code, q.maximum_marks, i.instruction_id, i.instruction_code, i.instruction_text, q.duration, b.batch_id, b.batch_code, "
			+ "b.batch_start_time, b.batch_end_time, c.center_id, c.center_code, c.center_name, e.examdrive_id, e.examdrive_code, e.examdrive_name, co.course_master_id, "
			+ "co.course_code, co.course_name) FROM Center c INNER JOIN Batch b ON c.center_id = b.center_id INNER JOIN QuestionPaper q on q.batch_id = b.batch_id INNER JOIN"
			+ "Instruction i on i.qp_id = q.qp_id INNER JOIN Examdrive e on e.examdrive_id = b.examdrive_id INNER JOIN Course co ON e.course_master_id = co.course_master_id")
	List<Epack1> fetchData();
	
}
