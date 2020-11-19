package com.urest.v1.authoring_module.apack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApackJoinRepository extends JpaRepository<Apack, Integer>{
	@Query(nativeQuery = true, value = "SELECT q.qp_id, i.item_id, q.qp_item_id, i.item_text, i.marks, i.item_type FROM au_item i INNER JOIN au_qp_item q ON q.item_id = i.item_id")
	List<Object[]> fetchApack1Data();
	
	@Query(nativeQuery = true, value = "SELECT i.item_id, i.qp_item_id, o.item_mcq_id, o.mcq_option_text, o.mcq_option_marks FROM au_qp_item i INNER JOIN au_item_mcq_options o ON i.item_id = o.item_id")
	List<Object[]> fetchApack2McqData();
	
	@Query(nativeQuery = true, value = "SELECT i.item_id, i.qp_item_id, o.item_true_false_id, o.true_percent, o.false_percent FROM au_qp_item i INNER JOIN au_item_true_false o ON i.item_id = o.item_id")
	List<Object[]> fetchApack2TFData();
	
}
