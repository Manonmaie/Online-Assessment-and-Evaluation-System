package com.iiitb.examAdminBackEnd.batch;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BatchRepository extends CrudRepository<Batch, Integer>{
	public List<Batch> findByExamdriveExamdriveId(int id);
	
	@Query(value="SELECT batch_code FROM ea_batch", nativeQuery=true)
	public List<String> findBatchCodes();
}
