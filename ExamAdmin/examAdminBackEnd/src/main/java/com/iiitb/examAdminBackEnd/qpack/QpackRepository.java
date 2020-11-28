package com.iiitb.examAdminBackEnd.qpack;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QpackRepository extends CrudRepository<Qpack, Integer>{
	@Query(value="SELECT DISTINCT(qp_id), maximum_marks, duration, batch_code FROM qpack1", nativeQuery=true)
	public List<Object[]> fetchQPdata();
	
	@Query(value="SELECT DISTINCT instruction_id, qp_id, instruction_text FROM qpack1", nativeQuery=true)
	public List<Object[]> fetchInstructionsdata();
}
