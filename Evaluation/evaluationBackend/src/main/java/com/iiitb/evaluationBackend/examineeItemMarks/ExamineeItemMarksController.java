package com.iiitb.evaluationBackend.examineeItemMarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExamineeItemMarksController {
	
	@Autowired
	private ExamineeItemMarksService examineeItemMarksService;
	
	@RequestMapping(value = "/response/setExamineeItemMarks", headers="Content-Type=application/json", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<EvExamineeItemMarks> addMarks(@RequestBody EvExamineeItemMarks examineeItemMarks){
		return new ResponseEntity<EvExamineeItemMarks>(examineeItemMarksService.addMarks(examineeItemMarks),HttpStatus.OK);
	}
}
