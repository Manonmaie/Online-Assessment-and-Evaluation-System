package com.urest.v1.authoring_module.apack1;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Apack1Repository extends CrudRepository<Apack1, Integer>{
	@Query(nativeQuery = true, value = "SELECT * from apack1 where apack1_id = (SELECT MIN(apack1_id) FROM apack1 WHERE qp_item_id = :qp_item_id)")
	Apack1 getApack1ByQpItemId(@Param("qp_item_id") int qp_item_id);
}
