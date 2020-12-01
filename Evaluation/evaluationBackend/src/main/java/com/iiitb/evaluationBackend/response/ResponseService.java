package com.iiitb.evaluationBackend.response;

import java.util.List;
import java.util.Optional;

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
	
	public List<EvResponse> getResponseFromExamineeBatchId(int examineeBatchId){
		return responseRepository.findByEvExamineeBatchExamineeBatchId(examineeBatchId);
	}
	
	public void addResponse(EvResponse response) {
		responseRepository.save(response);
	}
	
	public Optional<EvResponse> getResponseByQpItemIdExamineeBatchId(int qp_item_id, int examinee_batch_id){
		return responseRepository.getResponseByQpItemIdExamineeBatchId(qp_item_id, examinee_batch_id);
	}
}
