package com.iiitb.assessmentBackEnd.responseMcq;

import org.springframework.data.repository.CrudRepository;

public interface ResponseMcqRepository extends CrudRepository<AsResponseMcq, Integer> {
	
	AsResponseMcq findByResponseMcqId(int responseMcqId); 
}
