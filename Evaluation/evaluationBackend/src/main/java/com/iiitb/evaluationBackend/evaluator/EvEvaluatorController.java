package com.iiitb.evaluationBackend.evaluator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.evaluationBackend.evaluator.EvEvaluator;
import com.iiitb.evaluationBackend.evaluator.EvEvaluatorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EvEvaluatorController {
	
	@Autowired
	private EvEvaluatorService evaluatorService;
	
	@RequestMapping("/registrationNo/{evaluatorCode}/password/{password}/evaluator")
	public EvEvaluator getAllEvaluators(@PathVariable String evaluatorCode, @PathVariable String password) {
		return evaluatorService.getEvaluatorForRegistrationNumberAndPassword(evaluatorCode, password);
	}
	
}
