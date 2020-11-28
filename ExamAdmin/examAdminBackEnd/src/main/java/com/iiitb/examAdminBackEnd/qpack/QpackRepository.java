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
	
	@Query(value="SELECT DISTINCT qp_item_id, item_text, item_marks, item_type, cognitive_level, qp_id FROM qpack2", nativeQuery=true)
	public List<Object[]> fetchQpItemdata();
	
	@Query(value="SELECT DISTINCT qp_item_id, item_option_id, option_text FROM qpack3", nativeQuery=true)
	public List<Object[]> fetchItemOptionsdata();
	
	@Query(value="SELECT DISTINCT examinee_batch_id, qp_item_id, examinee_item_marks from mpack3", nativeQuery=true)
	public List<Object[]> fetchExamineeBatchMarksdata();
}
