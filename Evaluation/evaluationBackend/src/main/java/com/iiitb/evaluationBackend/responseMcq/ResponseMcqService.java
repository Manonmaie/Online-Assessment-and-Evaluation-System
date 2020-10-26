package com.iiitb.evaluationBackend.responseMcq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.responseMcq.EvResponseMcq;
import com.iiitb.evaluationBackend.responseMcq.ResponseMcqRepository;

@Service
public class ResponseMcqService {
	
	@Autowired
	private ResponseMcqRepository responseMcqRepository; 
	
	public void addResponseMcq(EvResponseMcq asResponseMcq) {
		responseMcqRepository.save(asResponseMcq);
	}

	public EvResponseMcq getResponseMcqForResponseId(int responseMcqId) {
		return responseMcqRepository.findByResponseMcqId(responseMcqId);
	}

}
