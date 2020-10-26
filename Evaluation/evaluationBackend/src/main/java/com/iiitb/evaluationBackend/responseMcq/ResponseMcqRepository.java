package com.iiitb.evaluationBackend.responseMcq;

import org.springframework.data.repository.CrudRepository;

import com.iiitb.evaluationBackend.responseMcq.EvResponseMcq;

public interface ResponseMcqRepository extends CrudRepository<EvResponseMcq, Integer> {
	
	EvResponseMcq findByResponseMcqId(int responseMcqId); 
}
