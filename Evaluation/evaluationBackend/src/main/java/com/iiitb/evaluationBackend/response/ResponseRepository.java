package com.iiitb.evaluationBackend.response;

import org.springframework.data.repository.CrudRepository;

import com.iiitb.evaluationBackend.response.EvResponse;

public interface ResponseRepository extends CrudRepository<EvResponse, Integer>{
	
	EvResponse findByResponseId(int responseId); 
}
