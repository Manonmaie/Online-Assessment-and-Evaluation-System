package com.iiitb.evaluationBackend.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.response.ResponseRepository;

@Service
public class ResponseService {
	
	@Autowired
	private ResponseRepository responseRepository;
	
	public EvResponse getResponseFromId(int responseId) {
		return responseRepository.findByResponseId(responseId);
	}
	
	public List<EvResponse> getEvQpItemQpItemId(int qpItemId){
		return responseRepository.findByEvQpItemQpItemId(qpItemId);
	}
}
