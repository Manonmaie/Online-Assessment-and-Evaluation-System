package com.iiitb.evaluationBackend.response;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iiitb.evaluationBackend.response.EvResponse;


public interface ResponseRepository extends CrudRepository<EvResponse, Integer>{
	
	EvResponse findByResponseId(int responseId); 
	List<EvResponse> findByEvQpItemQpItemId(int qpItemId);
	List<EvResponse> findByEvExamineeBatchExamineeBatchId(int examineeBatchId);
	
	@Query(nativeQuery = true, value = "select * from ev_response where qp_item_id = :qp_item_id and examinee_batch_id = :examinee_batch_id")
	Optional<EvResponse> getResponseByQpItemIdExamineeBatchId(@Param("qp_item_id") int qp_item_id, @Param("examinee_batch_id") int examinee_batch_id);
	
}
