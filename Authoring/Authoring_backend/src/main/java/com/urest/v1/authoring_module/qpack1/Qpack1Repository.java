package com.urest.v1.authoring_module.qpack1;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Qpack1Repository extends CrudRepository<Qpack1, Integer>{
	@Query(nativeQuery = true, value = "SELECT qp_id, min(qpack1_id) from qpack1 group by qp_id")
	List<Object[]> getUniqueQPQpacks();
	
	Qpack1 findById(int id);
	
}
