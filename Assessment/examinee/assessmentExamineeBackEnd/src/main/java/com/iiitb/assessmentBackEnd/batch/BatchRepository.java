package com.iiitb.assessmentBackEnd.batch;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BatchRepository extends CrudRepository<AsBatch, Integer> {
	

	List<AsBatch> findDistinctByQpStatusAndAsExamineeBatchListExamineeBatchStatus(String qpStatus, String examineeBatchStatus);

}
