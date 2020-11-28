package com.iiitb.examAdminBackEnd.batch;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BatchRepository extends CrudRepository<Batch, Integer>{
	public List<Batch> findByExamdriveExamdriveId(int id);
	
	@Query(value="SELECT * FROM ea_batch WHERE batch_code = :batch_code", nativeQuery=true)
	public Batch findByBatchCode(@Param("batch_code") String batch_code);
	
	@Query(value="SELECT batch_code FROM ea_batch", nativeQuery=true)
	public List<String> findBatchCodes();
}
