package com.iiitb.assessmentBackEnd.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.assessmentBackEnd.responseMcq.AsResponseMcq;
import com.iiitb.assessmentBackEnd.responseMcq.ResponseMcqRepository;
import com.iiitb.assessmentBackEnd.responseMcq.ResponseMcqService;

@Service
public class ResponseService {
	
	@Autowired
	private ResponseRepository responseRepository;
//	@Autowired
//	private ResponseMcqRepository responseMcqRepository;
	
//	private ResponseMcqRepository responseMcqRepository;

	public AsResponse getResponseFromId(int responseId) {
		return responseRepository.findByResponseId(responseId);
	}
	
	public List<AsResponse> getResponseForQpItemAndAttempt(int qpItemId, int responseId) {
		return responseRepository.findByAsQpItemQpItemIdAndAsAttemptAttemptId(qpItemId, responseId);
	}
	
	public AsResponse addResponseAndResponseMcq(AsResponse response) {
//		AsResponse responseLocal = new AsResponse();
//		responseLocal.setAsAttempt(response.getAsAttempt());
//		responseLocal.setAsQpItem(response.getAsQpItem());
//		responseLocal.setResponseText(response.getResponseText());
		responseRepository.save(response);
		return response;
	}
	
//	public void addResponse(int qpItemtId, int attemptId, AsResponse response) {
////		response.setAsResponseMcq(asResponseMcq);
////		AsResponseMcq asResponseMcq = new AsResponseMcq();
////		asResponseMcq.setResponseMcqId(response.getAsResponseMcq().getResponseMcqId());
////		asResponseMcq.setResponseText(response.getAsResponseMcq().getResponseText());
////		asResponseMcq.setAsResponse(response);
////		responseMcqService.addResponseMcq(asResponseMcq);
////		responseMcqRepository.save(response.getAsResponseMcq());
////		userRequest.getUserProfile().setUser(userRequest);
////		System.out.println("responsessss");
////		System.out.println("responseId = " + response.getResponseId());
////		response.getAsQpItem().setQpItemId(qpItemtId);
////		response.getAsQpItem().setQpItemId(attemptId);
//		responseRepository.save(response);
////		System.out.println("responsessss 1");
////		System.out.println("response = " + response.getAsResponseMcq().getResponseMcqId());
////		System.out.println("responsessss 22");
////		AsResponseMcq asResponseMcq = response.getAsResponseMcq();
////		asResponseMcq.setAsResponse(response);
////		responseMcqRepository.save(asResponseMcq);
////		System.out.println("responseId = " + response.getAsResponseMcq().getAsResponse().getResponseId());
////		AsResponseMcq asResponseMcq = response.getAsResponseMcq();
////		if (asResponseMcq == null) {
////			asResponseMcq = new AsResponseMcq();
////			asResponseMcq.setAsResponse(response);
////		}
////		responseMcqRepository.save(asResponseMcq);
//	}

	public AsResponse getLastRowFromResponse() {
		return responseRepository.findTopByOrderByResponseIdDesc();
	}
	
}
