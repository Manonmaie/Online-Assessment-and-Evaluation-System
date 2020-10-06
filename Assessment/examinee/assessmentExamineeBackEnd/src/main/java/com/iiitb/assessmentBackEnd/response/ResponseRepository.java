package com.iiitb.assessmentBackEnd.response;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResponseRepository  extends CrudRepository<AsResponse, Integer> {
	
	AsResponse findByResponseId(int responseId); 
	List<AsResponse> findByAsQpItemQpItemIdAndAsAttemptAttemptId(int qpItemId, int attemptId); 
	AsResponse findTopByOrderByResponseIdDesc();
}
