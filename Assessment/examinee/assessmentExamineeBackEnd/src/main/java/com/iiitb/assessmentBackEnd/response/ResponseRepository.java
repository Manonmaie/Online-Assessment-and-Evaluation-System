package com.iiitb.assessmentBackEnd.response;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iiitb.assessmentBackEnd.examineeBatch.ExamineeBatchKey;

public interface ResponseRepository  extends CrudRepository<AsResponse, Integer> {
	
	AsResponse findByResponseId(int responseId); 
	AsResponse findByAsQpItemQpItemIdAndAsAttemptAttemptIdAndResponseText(int qpItemId, int attemptId, String responseText); 
	AsResponse findTopByOrderByResponseIdDesc();
	AsResponse findByAsQpItemQpItemIdAndAsAttemptAttemptId(int qpItemId, int attemptId);
	List<AsResponse> findByAsQpItemAsQuestionPaperAsBatchBatchId(int batchId);
	List<AsResponse> findByAsAttemptAsExamineeBatchBatchBatchIdAndAsAttemptAttemptStatus(int batchId, String attemptStatus);
	List<AsResponse> findByAsAttemptAttemptId(int attemptId);
}
