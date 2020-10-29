package com.iiitb.evaluationBackend.response;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iiitb.evaluationBackend.response.EvResponse;


public interface ResponseRepository extends CrudRepository<EvResponse, Integer>{
	
	EvResponse findByResponseId(int responseId); 
	List<EvResponse> findByEvQpItemQpItemId(int qpItemId);
	List<EvResponse> findByEvExamineeBatchExamineeBatchId(int examineeBatchId);
	
}
