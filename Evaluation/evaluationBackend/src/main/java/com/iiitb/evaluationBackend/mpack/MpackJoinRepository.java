package com.iiitb.evaluationBackend.mpack;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MpackJoinRepository extends JpaRepository<Mpack, Integer>{
	@Query(nativeQuery = true, value = "SELECT q.qp_id, q.maximum_marks, q.duration FROM ev_question_paper q")
	List<Object[]> fetchMpack1Data();
	
	@Query(nativeQuery = true, value = "SELECT q.qp_id, q.qp_item_id, q.item_text, q.item_marks, q.item_type FROM ev_qp_item q WHERE q.qp_id = :qp_id")
	List<Object[]> fetchMpack2Data(@Param("qp_id") int qp_id);
	
	@Query(nativeQuery = true, value = "SELECT i.qp_id, eim.examinee_batch_id, eim.qp_item_id, eim.examinee_item_marks FROM ev_examinee_item_marks eim "
			+ "INNER JOIN ev_qp_item i ON i.qp_item_id = eim.qp_item_id INNER JOIN ev_examinee_batch e ON e.examinee_batch_id = eim.examinee_batch_id "
			+ "WHERE eim.qp_item_id = :qp_item_id")
	List<Object[]> fetchMpack3Data(@Param("qp_item_id") int qp_item_id);
}
