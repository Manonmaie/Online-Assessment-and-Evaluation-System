package com.iiitb.evaluationBackend.Rpack;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RpackRepository extends CrudRepository<Rpack, Integer>{
	@Query(value="SELECT DISTINCT qp_id, maximum_marks, duration FROM rpack1", nativeQuery=true)
	public List<Object[]> fetchQPdata();
	
	@Query(value="SELECT DISTINCT qp_item_id, item_text, item_marks, item_type, qp_id FROM rpack2", nativeQuery=true)
	public List<Object[]> fetchQpItemData();
	
	@Query(value="SELECT DISTINCT examinee_batch_id from rpack4", nativeQuery=true)
	public List<Integer> fetchExamineeBatchData();
	
	@Query(value="SELECT DISTINCT examinee_batch_id, qp_item_id, response_id, response_text FROM rpack4", nativeQuery=true)
	public List<Object[]> fetchResponseData();
}
