package com.iiitb.assessmentBackEnd.responseMcq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.assessmentBackEnd.response.AsResponse;

@Service
public class ResponseMcqService {
	
	@Autowired
	private ResponseMcqRepository responseMcqRepository; 
	
	public void addResponseMcq(AsResponseMcq asResponseMcq) {
//		AsResponse asResponse = new AsResponse();
//		asResponse.set
		responseMcqRepository.save(asResponseMcq);
	}

	public AsResponseMcq getResponseMcqForResponseId(int responseMcqId) {
		return responseMcqRepository.findByResponseMcqId(responseMcqId);
	}

}
