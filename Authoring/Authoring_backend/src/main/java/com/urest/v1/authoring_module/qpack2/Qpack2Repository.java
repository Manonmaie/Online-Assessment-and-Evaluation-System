package com.urest.v1.authoring_module.qpack2;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Qpack2Repository extends CrudRepository<Qpack2, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * from qpack2 where qpack2_id = (SELECT MIN(qpack2_id) FROM qpack2 WHERE qp_item_id = :qp_item_id)")
	Qpack2 getQpack2ByQpItemId(@Param("qp_item_id") int qp_item_id);
}
