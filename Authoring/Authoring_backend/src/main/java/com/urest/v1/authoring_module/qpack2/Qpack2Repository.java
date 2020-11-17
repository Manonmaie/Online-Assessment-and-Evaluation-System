package com.urest.v1.authoring_module.qpack2;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Qpack2Repository extends CrudRepository<Qpack2, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * from qpack2 where qpack2_id = (SELECT MIN(qpack2_id) FROM qpack2 WHERE item_id = :item_id)")
	Qpack2 getQpack2ByItemId(@Param("item_id") int item_id);
}
