package com.iiitb.assessmentBackEnd.response;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResponseRepository  extends CrudRepository<AsResponse, Integer> {
	
	AsResponse findByResponseId(int responseId); 
	AsResponse findByAsQpItemQpItemIdAndAsAttemptAttemptIdAndResponseText(int qpItemId, int attemptId, String responseText); 
	AsResponse findTopByOrderByResponseIdDesc();
}
