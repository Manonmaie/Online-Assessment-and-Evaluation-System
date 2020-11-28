package com.iiitb.examAdminBackEnd.mpack;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MpackRepository extends CrudRepository<Mpack, Integer>{
	@Query(value="SELECT DISTINCT examinee_batch_id, qp_item_id, examinee_item_marks from mpack3", nativeQuery=true)
	public List<Object[]> fetchExamineeBatchMarksdata();
}
