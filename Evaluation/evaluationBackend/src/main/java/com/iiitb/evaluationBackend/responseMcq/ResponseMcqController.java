package com.iiitb.evaluationBackend.responseMcq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.evaluationBackend.responseMcq.EvResponseMcq;
import com.iiitb.evaluationBackend.responseMcq.ResponseMcqService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResponseMcqController {
	
	@Autowired
	private ResponseMcqService responseMcqService;
	
	@RequestMapping("/response/{responseId}/responseMcq/{responseMcqId}")
	public EvResponseMcq getResponseMcqForResponseId(@PathVariable int responseMcqId){
		return responseMcqService.getResponseMcqForResponseId(responseMcqId);
	}

}
