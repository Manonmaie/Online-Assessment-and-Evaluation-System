package com.iiitb.assessmentBackEnd.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResponseController {
	
	@Autowired
	private ResponseService responseService;
	
	@RequestMapping("/qpItem/{qpItemId}/attempt/{attemptId}/response/{responseId}")
	public AsResponse getResponseFromId(@PathVariable int responseId){
		return responseService.getResponseFromId(responseId);
	}
	
//	@RequestMapping("/qpItem/{qpItemId}/attempt/{attemptId}/response")
//	public List<AsResponse> getResponseForQpItemAndAttempt(@PathVariable int qpItemId, @PathVariable int attemptId){
//		return responseService.getResponseForQpItemAndAttempt(qpItemId, attemptId);
//	}
	
	@RequestMapping("/response/lastRow")
	public AsResponse getLastRowFromResponse(){
		return responseService.getLastRowFromResponse();
	}
	
	@RequestMapping(value = "/response/setResponse", headers="Content-Type=application/json", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<AsResponse> addResponse(@RequestBody AsResponse response) {
        return new ResponseEntity<AsResponse>(responseService.addResponseAndResponseMcq(response),HttpStatus.OK);

    }
	
//	@RequestMapping(method=RequestMethod.POST, value="/qpItem/{qpItemId}/attempt/{attemptId}/response")
//	@ResponseBody
//	public ResponseEntity<AsResponse> addResponse(@RequestBody AsResponse response, @PathVariable int qpItemId, @PathVariable int attemptId) {
//		return new ResponseEntity<AsResponse>(responseService.addResponseAndResponseMcq(response),HttpStatus.OK);
////		return responseService.addResponseAndResponseMcq(response);
//	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/qpItem/{qpItemId}/attempt/{attemptId}/response")
//	public void addResponse(@RequestBody AsResponse response, @PathVariable int qpItemId, @PathVariable int attemptId) {
//		responseService.addResponse(qpItemId, attemptId, response);
//	}
}
