package com.iiitb.evaluationBackend.mpack;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MpackJoinRepository extends JpaRepository<Mpack, Integer>{
	@Query(nativeQuery = true, value = "SELECT q.qp_id, q.maximum_marks, q.duration FROM ev_question_paper q")
	List<Object[]> fetchMpack1Data();
}
