package com.iiitb.evaluationBackend.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.evaluationBackend.response.EvResponse;
import com.iiitb.evaluationBackend.response.ResponseService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResponseController {
	
	@Autowired
	private ResponseService responseService;
	
	@RequestMapping("/qpItem/{qpItemId}/responses")
	public List<EvResponse> getEvQpItemQpItemId(@PathVariable int qpItemId){
		return responseService.getEvQpItemQpItemId(qpItemId);
	}
	
	@RequestMapping("/examdrive/{examineeBatchId}/responses")
	public List<EvResponse> getResponseFromExamineeBatchId(@PathVariable int examineeBatchId){
		return responseService.getResponseFromExamineeBatchId(examineeBatchId);
	}
	
}
