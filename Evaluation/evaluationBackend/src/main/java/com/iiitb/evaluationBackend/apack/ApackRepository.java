package com.iiitb.evaluationBackend.apack;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ApackRepository extends CrudRepository<Apack, Integer>{
	@Query(value="SELECT DISTINCT qp_id, qp_item_id, item_text, item_type item_marks FROM apack1", nativeQuery=true)
	public List<Object[]> fetchQpItemdata();
}
