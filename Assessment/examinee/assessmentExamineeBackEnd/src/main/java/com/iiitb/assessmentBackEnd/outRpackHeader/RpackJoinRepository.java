package com.iiitb.assessmentBackEnd.outRpackHeader;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RpackJoinRepository extends JpaRepository<OutRpackHeader, Integer>{
	@Query(nativeQuery = true, value = "SELECT q.qp_id, q.maximum_marks, q.duration, q.batch_id FROM as_question_paper q")
	public List<Object[]> fetchRpack1Data();
	
	@Query(nativeQuery = true, value = "SELECT i.qp_id, i.qp_item_id, i.item_text, i.item_marks, i.item_type, i.cognitive_level FROM as_qp_item i WHERE i.qp_id = :qp_id")
	public List<Object[]> fetchRpack2Data(@Param("qp_id") int qp_id);
	
	@Query(nativeQuery = true, value = "SELECT o.qp_item_id, o.item_mcq_id, o.mcq_option_text FROM as_item_mcq_options o WHERE o.qp_item_id = :qp_item_id")
	List<Object[]> fetchRpack3McqData(@Param("qp_item_id") int qp_item_id);
	
	@Query(nativeQuery = true, value = "SELECT o.qp_item_id, o.item_true_false_id FROM as_item_true_false o WHERE o.qp_item_id = :qp_item_id")
	List<Object[]> fetchRpack3TFData(@Param("qp_item_id") int qp_item_id);
	
	@Query(nativeQuery = true, value = "SELECT q.qp_id, q.batch_id, eb.examinee_batch_id, eb.examinee_id, r.qp_item_id, r.response_id, "
			+ "r.response_text FROM as_response r INNER JOIN as_attempt a  ON r.attempt_id = a.attempt_id INNER JOIN as_examinee_batch eb "
			+ "ON eb.examinee_id = a.examinee_id AND eb.batch_id = a.batch_id INNER JOIN as_question_paper q ON  q.batch_id = eb.batch_id "
			+ "where r.qp_item_id = :qp_item_id")
	List<Object[]> fetchRpack4Data(@Param("qp_item_id") int qp_item_id);
}
