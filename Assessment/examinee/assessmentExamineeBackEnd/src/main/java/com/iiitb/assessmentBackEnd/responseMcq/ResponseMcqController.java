package com.iiitb.assessmentBackEnd.responseMcq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.iiitb.assessmentBackEnd.response.AsResponse;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResponseMcqController {
	
	@Autowired
	private ResponseMcqService responseMcqService;
	
	@RequestMapping("/response/{responseId}/responseMcq/{responseMcqId}")
	public AsResponseMcq getResponseMcqForResponseId(@PathVariable int responseMcqId){
		return responseMcqService.getResponseMcqForResponseId(responseMcqId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/response/{responseId}/responseMcq")
	public void addResponseMcq(@RequestBody AsResponseMcq responseMcq, @PathVariable int responseId) {
		responseMcqService.addResponseMcq(responseMcq);
	}
//	{"responseMcqId":0,"responseText":"Collection of related data","asResponse":{"responseId":5,"asQpItem":{"qpItemId":2},"asAttempt":{"attemptId":1}}}
}
