package com.iiitb.examAdminBackEnd.qp_item;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QpItemRepository extends CrudRepository<QpItem, Integer>{
	@Query(value = "SELECT * FROM ea_qp_item WHERE qp_item_id = :qp_item_id", nativeQuery = true)
	public QpItem findById(@Param("qp_item_id") int qp_item_id);
}
