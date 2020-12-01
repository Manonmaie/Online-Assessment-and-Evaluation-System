package com.iiitb.evaluationBackend.Rpack;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RpackRepository extends CrudRepository<Rpack, Integer>{
	@Query(value="SELECT DISTINCT qp_id, maximum_marks, duration FROM rpack1", nativeQuery=true)
	public List<Object[]> fetchQPdata();
	
	@Query(value="SELECT DISTINCT qp_item_id, item_text, item_marks, item_type, qp_id FROM rpack2", nativeQuery=true)
	public List<Object[]> fetchQpItemData();
	
	@Query(value="SELECT DISTINCT qp_item_id, item_option_id, option_text FROM rpack3", nativeQuery=true)
	public List<Object[]> fetchItemOptionsData();
	
	@Query(value="SELECT option_percentage FROM apack2 WHERE qp_item_id = :qp_item_id and option_text =:option_text", nativeQuery=true)
	public Integer fetchItemTFPercentData(@Param("qp_item_id") int qp_item_id, @Param("option_text")String option_text);
	
	@Query(value="SELECT option_percentage FROM apack2 WHERE qp_item_id = :qp_item_id and item_option_id = :item_option_id", nativeQuery=true)
	public Integer fetchItemMcqPercentData(@Param("qp_item_id") int qp_item_id, @Param("item_option_id") int item_option_id);
	
	@Query(value="SELECT DISTINCT examinee_batch_id from rpack4", nativeQuery=true)
	public List<Integer> fetchExamineeBatchData();
	
	@Query(value="SELECT DISTINCT examinee_batch_id, qp_item_id, response_id, response_text FROM rpack4", nativeQuery=true)
	public List<Object[]> fetchResponseData();
}
