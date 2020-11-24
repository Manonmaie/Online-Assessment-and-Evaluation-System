package com.iiitb.assessmentBackEnd.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.assessmentBackEnd.attempt.AsAttempt;
import com.iiitb.assessmentBackEnd.attempt.AttemptRepository;
import com.iiitb.assessmentBackEnd.examineeBatch.ExamineeBatchKey;
import com.iiitb.assessmentBackEnd.responseMcq.AsResponseMcq;
import com.iiitb.assessmentBackEnd.responseMcq.ResponseMcqRepository;
import com.iiitb.assessmentBackEnd.responseMcq.ResponseMcqService;

@Service
public class ResponseService {
	
	@Autowired
	private ResponseRepository responseRepository;
	
	@Autowired
	private AttemptRepository attemptRepository;

	public AsResponse getResponseFromId(int responseId) {
		return responseRepository.findByResponseId(responseId);
	}
	
	public AsResponse getResponseForQpItemAndAttemptAndResponseText(int qpItemId, int attempId, String responseText) {
		return responseRepository.findByAsQpItemQpItemIdAndAsAttemptAttemptIdAndResponseText(qpItemId, attempId, responseText);
	}
	
	public AsResponse getResponseForQpItemAndAttemptForRadioButton(int qpItemId, int examineeId, int batchId) {
		int attemptId = attemptRepository.findTopByAsExamineeBatchExamineeBatchIdExamineeIdAndAsExamineeBatchExamineeBatchIdBatchIdOrderByAttemptNumberDesc(examineeId, batchId).getAttemptId();
		return responseRepository.findByAsQpItemQpItemIdAndAsAttemptAttemptId(qpItemId, attemptId);
	}
	
	public AsResponse addResponse(AsResponse response) {
		responseRepository.save(response);
		return response;
	}
	
	public AsResponse updateResponse(int responseId, AsResponse response) {
		responseRepository.save(response);
		return response;
	}
	
	public void deleteResponseByQpItemIdExamineeIdBatchId(int qpItemId, int examineeId, int batchId, String responseText) {
		int attemptId = attemptRepository.findTopByAsExamineeBatchExamineeBatchIdExamineeIdAndAsExamineeBatchExamineeBatchIdBatchIdOrderByAttemptNumberDesc(examineeId, batchId).getAttemptId();
		int responseId = getResponseForQpItemAndAttemptAndResponseText(qpItemId, attemptId, responseText).getResponseId();
		deleteResponse(responseId);
	}
	
	public void deleteResponse(int responseId) {
		responseRepository.deleteById(responseId);
	}
	
	public List<AsResponse> getAllResponsesForBatchId(int batchId) {
//		return responseRepository.findByAsQpItemAsQuestionPaperAsBatchBatchId(batchId);
		return responseRepository.findByAsAttemptAsExamineeBatchBatchBatchIdAndAsAttemptAttemptStatus(batchId, "COMPLETED");
	}
	
	public List<AsResponse> getAllResponsesForExamineeAndBatchIds(int examineeId, int batchId) {
		int attemptId = attemptRepository.findTopByAsExamineeBatchExamineeBatchIdExamineeIdAndAsExamineeBatchExamineeBatchIdBatchIdOrderByAttemptNumberDesc(examineeId, batchId).getAttemptId();
		return responseRepository.findByAsAttemptAttemptId(attemptId);
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
